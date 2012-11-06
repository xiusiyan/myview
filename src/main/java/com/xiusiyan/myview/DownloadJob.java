package com.xiusiyan.myview;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.xiusiyan.myview.util.DalUtils;
import com.xiusiyan.myview.util.TemplateUtils;

/**
 * DownloadJob
 *
 * @author xiusiyan
 * @version 1.0, Sep 6, 2012
 * @see
 */
public class DownloadJob implements Job {

    private static final Logger LOGGER = Logger.getLogger(DownloadJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
        
        //get all topic list
        List<TopicInfo> topics = DalUtils.getInstance().getTopics();
        
        //download page      
        for(TopicInfo topic : topics){            
            TaobaoPage p = TaobaoPageDownloader.getInstance().download(topic.getUrl());
            LOGGER.debug(topic);
            LOGGER.debug(p);
            LOGGER.debug(p.getPrice());
            
            SimpleDateFormat timeFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
            String timeStr = timeFormater.format(cal.getTime());

            DalUtils.getInstance().insertData(topic.getId(), timeStr, p.getPrice().doubleValue());
            LOGGER.debug("insert " + p.getPrice().doubleValue());
        }
        
        //build template chart html code
        try {
            TemplateUtils.writeTxtFile();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(),e);
        }
    }

}
