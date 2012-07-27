package com.xiusiyan.myview;

import junit.framework.TestCase;

/**
 * UtilsTest
 *
 * @author xiusiyan
 * @version 1.0, 2012-7-27
 * @see
 */
public class UtilsTest extends TestCase {

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
    
    public void test01() throws Exception{
       System.out.println( Utils.pumpString("target/classes/template.txt"));
    }

    public void test02() throws Exception {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html>\n");
        buffer.append("<head>\n");
        buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\n");
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
        buffer.append("    <div id=\"chart_div\" style=\"width: 900px; height: 500px;\"></div>\n");
        buffer.append("  </body>\n");
        buffer.append("</html>\n");
        
        System.out.println(buffer.toString());
    }
}
