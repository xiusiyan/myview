package com.xiusiyan.myview;

import org.apache.log4j.Logger;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * DownloadJob
 *
 * @author xiusiyan
 * @version 1.0, Sep 6, 2012
 * @see
 */
public class DownloadJob implements Job {
    /**
    * Logger for this class
    */
    private static final Logger LOGGER = Logger.getLogger(DownloadJob.class);

    /* (non-Javadoc)
     * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
     */
    public void execute(JobExecutionContext context) throws JobExecutionException {
        
        //get all topic list
        List<TopicInfo> topics = DalUtils.getInstance().getTopics();
        
        //download page      
        for(TopicInfo topic : topics){            
            Page p = PageDownloader.getInstance().download(topic.getUrl());
            LOGGER.debug(p);
        }
        
        //parser html
        
        
        //insert data
        
        
        //build template chart html code
    }

}
