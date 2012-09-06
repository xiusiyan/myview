package com.xiusiyan.myview;

/**
 * Page
 *
 * @author xiusiyan
 * @version 1.0, Sep 6, 2012
 * @see
 */
public class Page {
    private String html;
    
    public Page(String html){
        this.html = html;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Page [html=%s]", this.html);
    }

}
