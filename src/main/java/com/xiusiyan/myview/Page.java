package com.xiusiyan.myview;

/**
 * Page
 *
 * @author xiusiyan
 * @version 1.0, Sep 6, 2012
 * @see
 */
public class Page {
    protected String html;
    protected String url;
    
    public Page(String url, String html){
        this.html = html;
        this.url = url;
    }

    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Page [url=%s]", this.url);
    }


    /**
     * @return the html
     */
    public String getHtml() {
        return this.html;
    }


    /**
     * @return the url
     */
    public String getUrl() {
        return this.url;
    }

}
