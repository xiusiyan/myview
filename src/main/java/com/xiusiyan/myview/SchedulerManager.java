package com.xiusiyan.myview;

import org.apache.log4j.Logger;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

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

            scheduler.shutdown();

        } catch (SchedulerException se) {
            LOGGER.error(se.getMessage(), se);
        }
        
        LOGGER.info("SchedulerManager start.");

    }
}
