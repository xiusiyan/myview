package com.xiusiyan.myview.util;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * TemplateUtils
 *
 * @author xiusiyan
 * @version 1.0, 2012-11-7
 * @see
 */
public class TemplateUtils {
    private static final Logger LOGGER = Logger.getLogger(TemplateUtils.class);
    
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
        template.append(DalUtils.getInstance().getTopicData());
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
        
        LOGGER.info("build index.html.");
    }
}
