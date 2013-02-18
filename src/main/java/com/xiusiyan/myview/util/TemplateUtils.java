package com.xiusiyan.myview.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.xiusiyan.myview.TopicInfo;

/**
 * TemplateUtils
 *
 * @author xiusiyan
 * @version 1.0, 2012-11-7
 * @see
 */
public class TemplateUtils {
    private static final Logger LOGGER = Logger.getLogger(TemplateUtils.class);
    
    public static void genHTML(List<TopicInfo> topics) throws IOException {
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
        template.append("##chartData##");
        template.append("      }\n");
        template.append("    </script>\n");
        template.append("  </head>\n");
        template.append("  <body>\n");
        template.append("##divData##");
        template.append("  </body>\n");
        template.append("</html>\n");

        StringBuffer chartDataBuf = new StringBuffer();
        for (int i = 0; i < topics.size(); i++) {
            chartDataBuf.append("        var data" + i + " = google.visualization.arrayToDataTable([");
            chartDataBuf.append("['时间', '价格'],");
            chartDataBuf.append(DalUtils.getInstance().getTopicData(topics.get(i).getId()));
            chartDataBuf.append("]);\n");
            chartDataBuf.append("");
            chartDataBuf.append("        var options" + i + " = {\n");
            chartDataBuf.append("          title: '" + topics.get(i).getTitle() + "'\n");
            chartDataBuf.append("        };\n");
            chartDataBuf.append("");
            chartDataBuf.append("        var chart" + i + " = new google.visualization.LineChart(document.getElementById('chart" + i + "_div'));\n");
            chartDataBuf.append("        chart" + i + ".draw(data" + i + ", options" + i + ");\n");
        }      
        
        StringBuffer divDataBuf = new StringBuffer();
        for (int i = 0; i < topics.size(); i++) {
            divDataBuf.append("    <div id=\"chart"+i+"_div\" style=\"width: 100%; height: 500px;\"></div>\n");
        }
        
        int beginIndex = 0;
        beginIndex = template.indexOf("##chartData##");
        
        template.replace(beginIndex, beginIndex+13, chartDataBuf.toString());
        
        beginIndex = template.indexOf("##divData##");
        
        template.replace(beginIndex, beginIndex+11, divDataBuf.toString());
        
        fw.write(template.toString(), 0, template.length());
        fw.flush();
        
        LOGGER.info("build index.html.");
    }
}
