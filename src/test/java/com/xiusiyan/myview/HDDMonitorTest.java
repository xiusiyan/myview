package com.xiusiyan.myview;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import junit.framework.TestCase;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * ChartTest
 *
 * @author xiusiyan
 * @version 1.0, 2012-7-27
 * @see
 */
public class HDDMonitorTest extends TestCase {

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
            StringBuffer strBuf = new StringBuffer();
            InputStream instream;
            BufferedReader rd;
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet("http://item.taobao.com/item.htm?id=5981598150");
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            if (entity == null) {
                throw new RuntimeException("");
            }

            String line = null;

            instream = entity.getContent();
            rd = new BufferedReader(new InputStreamReader(instream, "GBK"));

            while ((line = rd.readLine()) != null) {
                strBuf.append(line).append("\n");

            }

            instream.close();
            rd.close();
            
            System.out.println(strBuf);
    }
    
    public void test02() throws Exception {

        String tempStr = "";

        String line =    "<strong id=\"J_StrPrice\" >624.00</strong>元</li>";
        if (line.indexOf("<strong id=\"J_StrPrice\" >") >= 0) {
            int startIndex = line.indexOf(">");
            tempStr = line.substring(startIndex + 1);
            int lastIndex = tempStr.indexOf("<");
            tempStr = tempStr.substring(0, lastIndex);

            System.out.println(tempStr);
        }
    }
}
