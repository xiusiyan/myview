package com.xiusiyan.myview;

import org.apache.log4j.Logger;

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

//    static class MyTask extends TimerTask {
//
//        public void run() {
//            try {
//                String price = HDDMonitor.getPrice();
//                logger.info("price=" + price);
//
//                SimpleDateFormat timeFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
//                String timeStr = timeFormater.format(cal.getTime());
//
//                DalUtils.getInstance().insertData(1, timeStr, Double.parseDouble(price));
//                logger.info("insert " + price);
//
//                writeTxtFile();
//            } catch (Exception e) {
//                logger.error(e.getMessage(), e);
//            }
//        }
//
//        MyTask() {
//        }
//    }

    public HDDMonitor() {
    }

    public static void main(String args[]) throws Exception {
//        Timer timer = new Timer();
//        timer.schedule(new MyTask(), 1000L, 0x2932E00L);
        Launcher.main(args);
    }

//    public static void writeTxtFile() throws IOException {
//        FileWriter fw = new FileWriter("/var/www/index.html", false);
//
//        StringBuffer template = new StringBuffer();
//        template.append("<html>\n");
//        template.append("<head>\n");
//        template.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
//        template.append("    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>\n");
//        template.append("    <script type=\"text/javascript\">\n");
//        template.append("      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});\n");
//        template.append("      google.setOnLoadCallback(drawChart);\n");
//        template.append("      function drawChart() {\n");
//        template.append("        var data = google.visualization.arrayToDataTable([");
//        template.append("          ['时间', '价格'],");
//        template.append(DalUtils.getInstance().getTopicData());
//        template.append("        ]);\n");
//        template.append("");
//        template.append("        var options = {\n");
//        template.append("          title: '西部数据 2TB 价格趋势'\n");
//        template.append("        };\n");
//        template.append("");
//        template.append("        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));\n");
//        template.append("        chart.draw(data, options);\n");
//        template.append("      }\n");
//        template.append("    </script>\n");
//        template.append("  </head>\n");
//        template.append("  <body>\n");
//        template.append("    <div id=\"chart_div\" style=\"width: 100%; height: 500px;\"></div>\n");
//        template.append("  </body>\n");
//        template.append("</html>\n");
//
//        fw.write(template.toString(), 0, template.length());
//        fw.flush();
//        
//        logger.info("build index.html.");
//    }

//    private static String getPrice() throws Exception {
//        StringBuffer strBuf = new StringBuffer();
//        InputStream instream;
//        BufferedReader rd;
//        HttpClient httpclient = new DefaultHttpClient();
//        HttpGet httpget = new HttpGet("http://item.taobao.com/item.htm?id=5981598150");
//        HttpResponse response = httpclient.execute(httpget);
//        HttpEntity entity = response.getEntity();
//
//        if (entity == null) {
//            throw new RuntimeException("");
//        }
//
//        String line = null;
//        String tempStr = null;
//
//        instream = entity.getContent();
//        rd = new BufferedReader(new InputStreamReader(instream, "GBK"));
//
//        while ((line = rd.readLine()) != null) {
//            if (line.indexOf("<strong id=\"J_StrPrice\" >") >= 0) {
//                int startIndex = line.indexOf(">");
//                tempStr = line.substring(startIndex + 1);
//                int lastIndex = tempStr.indexOf("<");
//                tempStr = tempStr.substring(0, lastIndex);
//                strBuf.append(tempStr);
//                break;
//            }
//        }
//
//        instream.close();
//        rd.close();
//
//        return strBuf.toString();
//    }
}
