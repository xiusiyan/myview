package com.xiusiyan.myview;

import junit.framework.TestCase;

/**
 * PageDownloaderTest
 *
 * @author xiusiyan
 * @version 1.0, Sep 6, 2012
 * @see
 */
public class PageDownloaderTest extends TestCase {

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
    
    public void test_Download() throws Exception {
        String url = "http://item.taobao.com/item.htm?spm=a1z0k.1000775.1.23&id=16715799999";
        Page page = PageDownloader.getInstance().download(url);
        
        System.out.println(page);
    }

}
