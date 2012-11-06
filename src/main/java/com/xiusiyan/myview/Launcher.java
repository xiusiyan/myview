package com.xiusiyan.myview;

import org.apache.log4j.Logger;

public class Launcher {

    private static final Logger LOGGER = Logger.getLogger(Launcher.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        SchedulerManager.getInstance().start();
    }

}
