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

                DalUtils.getInstance().insertData(1, timeStr, Double.parseDouble(price));
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
        timer.schedule(new MyTask(), 1000L, 0x1499700L);
    }

    public static void writeTxtFile() throws IOException {
        FileWriter fw = new FileWriter("/var/www/index.html", false);

        StringBuffer template = new StringBuffer();
        template.append("<html>\n");
        template.append("<head>\n");
        template.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
        template.append("    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>\n");
        template.append("    <script type=\"text/javascript\">\n");
        template.append("      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});\n");
        template.append("      google.setOnLoadCallback(drawChart);\n");
        template.append("      function drawChart() {\n");
        template.append("        var data = google.visualization.arrayToDataTable([");
        template.append("          ['时间', '价格'],");
        template.append(DalUtils.getInstance().getChartData());
        template.append("        ]);\n");
        template.append("");
        template.append("        var options = {\n");
        template.append("          title: '西部数据 2TB 价格趋势'\n");
        template.append("        };\n");
        template.append("");
        template.append("        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));\n");
        template.append("        chart.draw(data, options);\n");
        template.append("      }\n");
        template.append("    </script>\n");
        template.append("  </head>\n");
        template.append("  <body>\n");
        template.append("    <div id=\"chart_div\" style=\"width: 100%; height: 500px;\"></div>\n");
        template.append("  </body>\n");
        template.append("</html>\n");

        fw.write(template.toString(), 0, template.length());
        fw.flush();
    }

    private static String getPrice() throws Exception {
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
        String tempStr = null;

        instream = entity.getContent();
        rd = new BufferedReader(new InputStreamReader(instream, "GBK"));

        while ((line = rd.readLine()) != null) {
            if (line.indexOf("<strong id=\"J_StrPrice\" >") > 0) {
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
