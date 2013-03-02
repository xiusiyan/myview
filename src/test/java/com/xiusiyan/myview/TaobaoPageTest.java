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
        TaobaoPage page = TaobaoPageDownloader.getInstance().download(url);
        
        BigDecimal price = page.getPrice();
        System.out.println(price + ", hasPromo=" + page.hasPromo);
    }
    
    public void test_2() throws Exception {
        String url = "http://item.taobao.com/item.htm?id=5981598150";
        TaobaoPage page = TaobaoPageDownloader.getInstance().download(url);
        
        BigDecimal price = page.getPrice();
        System.out.println(price + ", hasPromo=" + page.hasPromo);
    }
    
    public void test_3() throws Exception {
        String url = "http://item.taobao.com/item.htm?id=1724922181";
        TaobaoPage page = TaobaoPageDownloader.getInstance().download(url);
        
        BigDecimal price = page.getPrice();
        System.out.println(price + ", hasPromo=" + page.hasPromo);
    }
    
}
