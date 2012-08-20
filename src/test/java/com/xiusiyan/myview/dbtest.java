package com.xiusiyan.myview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.Assert;
import junit.framework.TestCase;
import junit.runner.Version;

/**
 * dbtest
 *
 * @author xiusiyan
 * @version 1.0, 2012-6-6
 * @see
 */
public class dbtest extends TestCase {

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

    /**
     * check db available
     * @throws Exception
     */
    public void testdbconnected() throws Exception {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://xiusiyan.com:3306/myview";
        String user = "myview";
        String password = "myview2012";

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                Assert.assertEquals("5.5.23-2", rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }

    public void test_TopicTable() throws Exception {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String dburl = "jdbc:mysql://xiusiyan.com:3306/myview";
        String user = "myview";
        String password = "myview2012";

        try {
            con = DriverManager.getConnection(dburl, user, password);
            st = con.createStatement();
            rs = st.executeQuery("select * from topic;");

            int id;
            String url;
            String regx;
            String title;
            String scheduler;

            while (rs.next()) {
                id = rs.getInt("id");
                url = rs.getString("url");
                regx = rs.getString("regx");
                title = rs.getString("title");
                scheduler = rs.getString("scheduler");

                TopicInfo topicInfo = new TopicInfo(id, url, regx, title, scheduler);

                System.out.println(topicInfo);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }

    public void test_TopicDataTable() throws Exception {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://xiusiyan.com:3306/myview";
        String user = "myview";
        String password = "myview2012";

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("select * from topic_data;");

            int id;
            int topid;
            String x_axis;
            String y_axis;
            Date create_time;

            while (rs.next()) {
                id = rs.getInt("id");
                topid = rs.getInt("topid");
                x_axis = rs.getString("x_axis");
                y_axis = rs.getString("y_axis");
                create_time = rs.getDate("create_time");

                TopicData topicData = new TopicData(id, topid, x_axis, y_axis, create_time);

                System.out.println(topicData);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }

    public void test_chartDataTest() throws Exception {
    }
}
