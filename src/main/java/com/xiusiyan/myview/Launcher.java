package com.xiusiyan.myview;

import java.util.List;

import org.apache.log4j.Logger;

import com.xiusiyan.myview.util.DalUtils;

public class Launcher {
    /**
    * Logger for this class
    */
    private static final Logger LOGGER = Logger.getLogger(Launcher.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    List<TopicInfo> topicList = DalUtils.getInstance().getTopics();
	    for(TopicInfo c : topicList){
	        System.out.println(c);
	    }
	    
	    SchedulerManager.getInstance().start();
	    Thread t = new Thread();
	    t.run();
	    
	    try {
            t.join();
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(),e);
        }
	}
}
