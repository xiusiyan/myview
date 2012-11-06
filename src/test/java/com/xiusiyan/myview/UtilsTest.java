package com.xiusiyan.myview;

import java.util.List;

import com.xiusiyan.myview.util.DalUtils;
import com.xiusiyan.myview.util.TemplateUtils;

import junit.framework.TestCase;

/**
 * UtilsTest
 *
 * @author xiusiyan
 * @version 1.0, 2012-7-27
 * @see
 */
public class UtilsTest extends TestCase {

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
    
//    public void test01() throws Exception{
//       System.out.println( Utils.pumpString("target/classes/template.txt"));
//    }
    
    public void test1() throws Exception{
        List<TopicInfo> topics = DalUtils.getInstance().getTopics();
        
        TemplateUtils.genHTML(topics);
        
        
        
    }
    
    
}
