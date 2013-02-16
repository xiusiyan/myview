package com.xiusiyan.myview;

import java.math.BigDecimal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


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
        Document doc = Jsoup.parse(html);
        
        org.jsoup.nodes.Element element = doc.getElementById("J_StrPrice");
        
        element = element.getElementsByAttributeValue("class","tb-rmb-num").first();
        
        String tmp = element.text();  
        
        BigDecimal bd = new BigDecimal(tmp);
        
        return bd;
    }

}
