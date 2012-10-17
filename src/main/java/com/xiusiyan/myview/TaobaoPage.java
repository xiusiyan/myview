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
    public TaobaoPage(String html) {
        super(html);
        // TODO Auto-generated constructor stub
    }

}
