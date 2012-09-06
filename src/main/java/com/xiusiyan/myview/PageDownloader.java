package com.xiusiyan.myview;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

/**
 * PageDownloader
 *
 * @author xiusiyan
 * @version 1.0, Sep 6, 2012
 * @see
 */
public class PageDownloader {
    static Logger logger = Logger.getLogger(PageDownloader.class.getName());
        
    private static PageDownloader instance = null;

    public static PageDownloader getInstance(){
        
        if (instance == null) {
            try {
                instance = new PageDownloader();
            } catch (Exception e) {
                logger.error(e.getMessage(),e);
            }
            
        }

        return instance;
    }

    public static Page download(String url) throws Exception{
        StringBuffer strBuf = new StringBuffer();
        InputStream instream;
        BufferedReader rd;
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();

        if (entity == null) {
            throw new RuntimeException("");
        }

        String line = null;

        instream = entity.getContent();
        rd = new BufferedReader(new InputStreamReader(instream, "GBK"));

        while ((line = rd.readLine()) != null) {
            strBuf.append(System.getProperty("line.separator"));
            strBuf.append(line);
        }

        instream.close();
        rd.close();

        
        return new Page(strBuf.toString());
        
    }
}
