package com.xiusiyan.myview;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * TaobaoPage
 *
 * @author xiusiyan
 * @version 1.0, Oct 17, 2012
 * @see
 */
public class TaobaoPage extends Page {
    
    BigDecimal price = new BigDecimal(-1);

    /**
     * @param html
     */
    public TaobaoPage(String url, String html) {
        super(url, html);
    }
    
    public BigDecimal getPrice(){
        int beginIndex = html.indexOf("<strong id=\"J_StrPrice\" >");
        
        int endIndex = html.substring(beginIndex+25).indexOf("<")+beginIndex+25;
        
        String tmp = html.substring(beginIndex +25, endIndex);        
        
        BigDecimal bd = new BigDecimal(tmp);
        
        return bd;
    }

}
