package com.xiusiyan.myview;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * HDDMonitor
 *
 * @author xiusiyan
 * @version 1.0, 2012-6-1
 * @see
 */
public class HDDMonitor {
    static class MyTask extends TimerTask {

        public void run() {
            try {
                String price = HDDMonitor.getPrice();
                System.out.println(price);
//                HDDMonitor.writeTxtFile(price);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        MyTask() {
        }
    }

    public HDDMonitor() {
    }

    public static void main(String args[]) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 1000L, 0x6ddd00L);
    }

    public static void writeTxtFile(String newStr) throws IOException {
        FileWriter fw = new FileWriter("/var/www/price.csv", true);
        SimpleDateFormat timeFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = timeFormater.format(new Date());
        String line = (new StringBuilder(String.valueOf(timeStr))).append(",").append(newStr)
                .append(System.getProperty("line.separator")).toString();
        fw.write(line, 0, line.length());
        fw.flush();
    }

    private static String getPrice()
        throws Exception
    {
        StringBuffer strBuf = new StringBuffer();
        InputStream instream;
        BufferedReader rd;
        HttpClient httpclient = new DefaultHttpClient();
        
        HttpGet httpget = new HttpGet("http://item.taobao.com/item.htm?id=5981598150");
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();

        if(entity == null)
        {
            throw new RuntimeException("");
        }
        

        
        String line = null;
        String tempStr = null;
        
        instream = entity.getContent();
        rd = new BufferedReader(new InputStreamReader(instream, "GBK"));
        
        while((line = rd.readLine()) != null) 
        {
            if(line.indexOf("<strong id=\"J_StrPrice\" >") > 0)
            {
                int startIndex = line.indexOf(">");
                tempStr = line.substring(startIndex + 1);
                int lastIndex = tempStr.indexOf("<");
                tempStr = tempStr.substring(0, lastIndex);
                strBuf.append(tempStr);
            }
        }

        instream.close();
        rd.close();
        
        return strBuf.toString();
    }
}
