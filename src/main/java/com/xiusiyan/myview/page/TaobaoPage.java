package com.xiusiyan.myview.page;

import java.math.BigDecimal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * TaobaoPage
 *
 * @author xiusiyan
 * @version 1.0, Oct 17, 2012
 * @see
 */
public class TaobaoPage extends Page {
    
    BigDecimal price = new BigDecimal(-1);
    boolean hasPromo = false;

    /**
     * @param html
     */
    public TaobaoPage(String url, String html) {
        super(url, html);
    }
    
    public BigDecimal getPrice() {
        Element ele = null;

        Document doc = Jsoup.parse(html);
        
        BigDecimal promotion = getPromotion(doc);
        
        if (promotion.intValue()>0) {
            hasPromo = true;
        }else{
            promotion = new BigDecimal(1000);
        }
        
        ele = doc.getElementById("J_StrPrice");
        ele = ele.getElementsByAttributeValue("class", "tb-rmb-num").first();


        BigDecimal bd = new BigDecimal(ele.text());


        return bd.multiply(promotion).divide(new BigDecimal(1000));

    }

    private BigDecimal getPromotion(Document doc){

        Elements scriptEles = doc.getElementsByTag("Script");
        String tmp = null;
        
        for ( Element ele : scriptEles){
            tmp = ele.data();
            int beginIndex = 0;
            int endIndex = 0;
            //valLimitPromInfo
            {
                beginIndex = tmp.indexOf("valLimitPromInfo");
                

                if (beginIndex > 0) {
                    tmp = ele.data().substring(beginIndex);
                    beginIndex = tmp.indexOf("discount");
                    tmp = tmp.substring(beginIndex);
                    beginIndex = tmp.indexOf(":");
                    endIndex = tmp.indexOf(",");
                    tmp = tmp.substring(beginIndex + 1, endIndex);

                    return new BigDecimal(tmp.trim());
                }
            }
            
            //valVipRate
            beginIndex = tmp.indexOf("valVipRate");
            endIndex = 0;
            if(beginIndex > 0){
                tmp = ele.data().substring(beginIndex);
                beginIndex = tmp.indexOf(":");
                endIndex = tmp.indexOf(",");
                tmp = tmp.substring(beginIndex+1, endIndex);
                return new BigDecimal(tmp.trim()).multiply(new BigDecimal(10));
                
            }
            
        }
        
        return new BigDecimal(0);
    }
    
    /**
     * @param hasPromo the hasPromo to set
     */
    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the hasPromo
     */
    public boolean isPromo() {
        return this.hasPromo;
    }

}
