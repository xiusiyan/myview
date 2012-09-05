package com.xiusiyan.myview;

import java.util.Date;

/**
 * TopicData
 *
 * @author xiusiyan
 * @version 1.0, 2012-7-27
 * @see
 */
public class TopicData {
    int id;
    int topid;
    String x_axis;
    String y_axis;
    Date create_time;

    /**
     * @param id
     * @param topid
     * @param x_axis
     * @param y_axis
     * @param create_time
     */
    public TopicData(int id, int topid, String x_axis, String y_axis, Date create_time) {
        this.id = id;
        this.topid = topid;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.create_time = create_time;
    }

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return the topid
     */
    public int getTopid() {
        return this.topid;
    }

    /**
     * @return the x_axis
     */
    public String getX_axis() {
        return this.x_axis;
    }

    /**
     * @return the y_axis
     */
    public String getY_axis() {
        return this.y_axis;
    }

    /**
     * @return the create_time
     */
    public Date getCreate_time() {
        return this.create_time;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("TopicData [id=%s, topid=%s, x_axis=%s, y_axis=%s, create_time=%s]", this.id, this.topid,
                             this.x_axis, this.y_axis, this.create_time);
    }
    
    
}
