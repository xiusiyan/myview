package com.xiusiyan.myview;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * 硬盘价格监控工具
 * 
 * 1.Spider
 * 2.记录数据
 * 3.Render
 *
 * @author xiusiyan
 * @version 1.0, 2012-6-1
 * @see
 */
public class HDDMonitor {
        
    static Logger logger = Logger.getLogger(HDDMonitor.class.getName());
    
    static class MyTask extends TimerTask {

        public void run() {
            try {
                String price = HDDMonitor.getPrice();
                System.out.println(price);
                DAL.getInstance().insertData(id, topid, x_axis, y_axis);
                logger.log(Level.INFO, "insert " + price);
                //TODO
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

    public static void insertDB(String newStr) throws IOException{
        
    }
    
    /**
     * 将数据写入文件
     * 
     * @param newStr
     * @throws IOException
     */
    public static void writeTxtFile(String newStr) throws IOException {
        FileWriter fw = new FileWriter("/var/www/price.csv", true);
        SimpleDateFormat timeFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        String timeStr = timeFormater.format(cal.getTime());
        String line = (new StringBuilder(String.valueOf(timeStr))).append(",").append(newStr)
                .append(System.getProperty("line.separator")).toString();
        fw.write(line, 0, line.length());
        fw.flush();
    }

    /*
     * 获得价格
     */
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
