package com.xiusiyan.myview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import com.xiusiyan.myview.page.TaobaoPage;

/**
 * PageDownloader
 *
 * @author xiusiyan
 * @version 1.0, Sep 6, 2012
 * @see
 */
public class TaobaoPageDownloader {
    static Logger logger = Logger.getLogger(TaobaoPageDownloader.class.getName());
        
    private static TaobaoPageDownloader instance = null;

    public static TaobaoPageDownloader getInstance(){
        
        if (instance == null) {
            try {
                instance = new TaobaoPageDownloader();
            } catch (Exception e) {
                logger.error(e.getMessage(),e);
            }
            
        }

        return instance;
    }

    TaobaoPage download(String url) {
        StringBuffer strBuf = new StringBuffer();
        InputStream instream;
        BufferedReader rd;
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        HttpResponse response = null;
        HttpEntity entity = null;
        String line = null;             
        
        try {
            response = httpclient.execute(httpget);
            entity = response.getEntity();
            instream = entity.getContent();
            rd = new BufferedReader(new InputStreamReader(instream, "GBK"));

            while ((line = rd.readLine()) != null) {
                strBuf.append(System.getProperty("line.separator"));
                strBuf.append(line);
            }

            instream.close();
            rd.close();
        } catch (ClientProtocolException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        
        return new TaobaoPage(url, strBuf.toString());
    }
}
