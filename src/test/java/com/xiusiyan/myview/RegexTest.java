package com.xiusiyan.myview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * RegexTest
 *
 * @author xiusiyan
 * @version 1.0, Aug 7, 2012
 * @see
 */
public class RegexTest extends TestCase {

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
    
    public void test01() throws Exception {
        String sample = "<span>价　　格：</span><strong id=\"J_StrPrice\" >685.00</strong>元  </li>";

        Pattern pattern = Pattern.compile("(?:id=\"J_StrPrice\"\\s>)([0-9]+.[0-9]+)(?!<)");
        Matcher matcher = pattern.matcher(sample);
        // Check all occurance
        while (matcher.find()) {
            System.out.println(matcher.groupCount());
//            System.out.print("Start index: " + matcher.start());
//            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
            
            sample = sample.substring(matcher.start(), matcher.end());
            
            System.out.println(sample);
            
        }
    }

}
