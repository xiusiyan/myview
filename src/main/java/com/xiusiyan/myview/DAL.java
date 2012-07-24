package com.xiusiyan.myview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class DAL {
    
    static Logger logger = Logger.getLogger(DAL.class.getName());
    
    String url = "jdbc:mysql://xiusiyan.com:3306/myview";
    String user = "myview";
    String password = "myview2012";

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    private static DAL instance = null;

    public static DAL getInstance(){
        if (instance == null) {
            try {
                instance = new DAL();
            } catch (Exception e) {
                logger.log(Level.WARNING, e.getMessage(),e);
            }
            
        }

        return instance;
    }
    
    private DAL() throws Exception{
        con = DriverManager.getConnection(url, user, password);
        st = con.createStatement();
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
            
            rs = st.executeQuery("SELECT * from topic");

            while (rs.next()) {
                TopicInfo info = new TopicInfo();
                info.setId(rs.getInt(1));
                info.setUrl(rs.getString(2));
                info.setRegx(rs.getString(3));
                info.setTitle(rs.getString(4));
                
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
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {

                logger.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
        return list;
    }

}
