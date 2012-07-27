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
                logger.log(Level.INFO, price);
                
                SimpleDateFormat timeFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
                String timeStr = timeFormater.format(cal.getTime());

                DalUtils.getInstance().insertData(1, timeStr, Double.parseDouble(price) );
                logger.log(Level.INFO, "insert " + price);
                
                writeTxtFile();
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage());
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
    
    /**
     * 将数据写入文件
     * 
     * @param newStr
     * @throws IOException
     */
    public static void writeTxtFile() throws IOException {
        FileWriter fw = new FileWriter("/var/www/index.html", false);
        
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html>\n");
        buffer.append("<head>\n");
        buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
        buffer.append("    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>\n");
        buffer.append("    <script type=\"text/javascript\">\n");
        buffer.append("      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});\n");
        buffer.append("      google.setOnLoadCallback(drawChart);\n");
        buffer.append("      function drawChart() {\n");
        buffer.append("        var data = google.visualization.arrayToDataTable([");
        buffer.append("          ['时间', '价格'],");
        buffer.append(DalUtils.getInstance().getChartData());
        buffer.append("        ]);\n");
        buffer.append("");
        buffer.append("        var options = {\n");
        buffer.append("          title: '西部数据 2TB 价格趋势'\n");
        buffer.append("        };\n");
        buffer.append("");
        buffer.append("        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));\n");
        buffer.append("        chart.draw(data, options);\n");
        buffer.append("      }\n");
        buffer.append("    </script>\n");
        buffer.append("  </head>\n");
        buffer.append("  <body>\n");
        buffer.append("    <div id=\"chart_div\" style=\"width: 100%; height: 500px;\"></div>\n");
        buffer.append("  </body>\n");
        buffer.append("</html>\n");
        

        fw.write(buffer.toString(), 0, buffer.length());
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
