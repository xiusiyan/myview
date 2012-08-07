package com.xiusiyan.myview;

import java.util.List;

import junit.framework.TestCase;

/**
 * DALTest
 *
 * @author xiusiyan
 * @version 1.0, 2012-6-7
 * @see
 */
public class DalTest extends TestCase {

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testInsertData(){
        DalUtils.getInstance().insertData(1, "a", 699);
    }
    
    public void testGetTopics(){
        List<TopicInfo> infos = DalUtils.getInstance().getTopics();
        
        for(TopicInfo info : infos){
            System.out.println(info);
        }
    }

    public void testGetChartData(){
        System.out.println(DalUtils.getInstance().getChartData());
    }
}