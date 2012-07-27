package com.xiusiyan.myview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DAL
 *
 * @author xiusiyan
 * @version 1.0, 2012-6-7
 * @see
 */
public class DalUtils {
    
    static Logger logger = Logger.getLogger(DalUtils.class.getName());
    
    String url = "jdbc:mysql://xiusiyan.com:3306/myview";
    String user = "myview";
    String password = "myview2012";

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    private static DalUtils instance = null;

    public static DalUtils getInstance(){
        if (instance == null) {
            try {
                instance = new DalUtils();
            } catch (Exception e) {
                logger.log(Level.WARNING, e.getMessage(),e);
            }
            
        }

        return instance;
    }
    
    private DalUtils() throws Exception{
        con = DriverManager.getConnection(url, user, password);
    }
    
    public void insertData(int topid, String x_axis, double y_axis ) {
        StringBuffer strb = new StringBuffer();
        strb.append("insert into topic_data (topid, x_axis, y_axis) values ('");
        strb.append(topid);
        strb.append("','");
        strb.append(x_axis);
        strb.append("','");
        strb.append(y_axis);
        strb.append("')");
        
        try {
            st = con.createStatement();
            int rt = st.executeUpdate(strb.toString());
            logger.log(Level.INFO, String.valueOf(rt));
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(),e);
        }finally{
            try {
                st.close();
            } catch (SQLException e) {
                logger.log(Level.WARNING, e.getMessage(), e);
            }
        }
        
    }
    
    public List<TopicInfo> getTopics(){
        
        List<TopicInfo> list = new ArrayList<TopicInfo>();
        
        try {
            st  =con.createStatement();
            rs = st.executeQuery("SELECT * from topic");

            while (rs.next()) {
                int id = rs.getInt("id");
                String url = rs.getString("url");
                String regx = rs.getString("regx");
                String title = rs.getString("title");
                TopicInfo info = new TopicInfo(id, url, regx, title);

                list.add(info);
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
//                if (con != null) {
//                    con.close();
//                }

            } catch (SQLException ex) {

                logger.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
        return list;
    }

    public TopicData getLastTopicData(){
        
        TopicData td = null;
        
        try {
            st  =con.createStatement();
            rs = st.executeQuery(" select * from topic_data where topid=1 order by id desc limit 1");

            
            if(rs.next()) {
                int id = rs.getInt("id");
                int topid = rs.getInt("topid");
                String x = rs.getString("x_axis");
                String y = rs.getString("y_axis");
                Date createTime = rs.getDate("create_time");
                
                td = new TopicData(id,topid,x,y,createTime);
            }            

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
//                if (con != null) {
//                    con.close();
//                }

            } catch (SQLException ex) {

                logger.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
        return td;
    }
    
    public String getChartData(){
        StringBuffer buff = new StringBuffer();
        
        try {
            st  =con.createStatement();
            rs = st.executeQuery("select * from topic_data order by create_time;");

            
            while (rs.next()) {
                String x = rs.getString("x_axis");
                String y = rs.getString("y_axis");
                //parse x
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d = sdf.parse(x);

                SimpleDateFormat formater = new SimpleDateFormat("MM-dd HH");               
                
                buff.append("['");
                buff.append(formater.format(d));
                buff.append("', ");
                buff.append(y);
                buff.append("],\n");
            }            

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
//                if (con != null) {
//                    con.close();
//                }

            } catch (SQLException ex) {

                logger.log(Level.WARNING, ex.getMessage(), ex);
            }
        }

        return  buff.substring(0, buff.length()-2);
    }
}
