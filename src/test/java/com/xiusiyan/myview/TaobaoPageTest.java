package com.xiusiyan.myview;

import java.math.BigDecimal;

import junit.framework.TestCase;

/**
 * TaobaoPageTest
 *
 * @author xiusiyan
 * @version 1.0, 2013-2-17
 * @see
 */
public class TaobaoPageTest extends TestCase {

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

    public void test_1() throws Exception {
        String url = "http://item.taobao.com/item.htm?spm=a1z0k.1000775.1.23&id=16715799999";
        Page page = TaobaoPageDownloader.getInstance().download(url);
        
        BigDecimal price = ((TaobaoPage)page).getPrice();
        System.out.println(price);
    }
}
