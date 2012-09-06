package com.xiusiyan.myview;

import org.apache.log4j.Logger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

/**
 * SchedulerManager
 *
 * @author xiusiyan
 * @version 1.0, Aug 7, 2012
 * @see
 */
public class SchedulerManager {
    /**
    * Logger for this class
    */
    private static final Logger LOGGER = Logger.getLogger(SchedulerManager.class);
    
    private static SchedulerManager m_instance = null;

    private SchedulerManager() {
    }

    public synchronized static SchedulerManager getInstance() {
        
        if (m_instance == null) {
            m_instance = new SchedulerManager();
        }
        
        return m_instance;
    }
    
    public void start(){
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            
            scheduler.start();
            
            //add job
            JobDetail job = newJob(DownloadJob.class).withIdentity("job1", "group1").build();

            Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow()
                    .withSchedule(simpleSchedule().withIntervalInHours(24).repeatForever()).build();
            
            scheduler.scheduleJob(job, trigger);
            
            scheduler.shutdown();

        } catch (SchedulerException se) {
            LOGGER.error(se.getMessage(), se);
        }
        
        LOGGER.info("SchedulerManager start.");

    }
}
