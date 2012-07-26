package com.xiusiyan.myview;

/**
 * TopicInfo
 *
 * @author xiusiyan
 * @version 1.0, 2012-6-7
 * @see
 */
public class TopicInfo {
    /**
     * ID
     */
    private int id;
    
    /**
     * URL
     */
    private String url;
    
    /**
     * 匹配规则
     */
    private String regx;
    
    /**
     * 标题
     */
    private String title;
    
    
    
    /**
     * @param id
     * @param url
     * @param regx
     * @param title
     */
    public TopicInfo(int id, String url, String regx, String title) {
        this.id = id;
        this.url = url;
        this.regx = regx;
        this.title = title;
    }
    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the url
     */
    public String getUrl() {
        return this.url;
    }
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * @return the regx
     */
    public String getRegx() {
        return this.regx;
    }
    /**
     * @param regx the regx to set
     */
    public void setRegx(String regx) {
        this.regx = regx;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("TopicInfo [id=%s, url=%s, regx=%s, title=%s]", this.id, this.url, this.regx, this.title);
    }

}
