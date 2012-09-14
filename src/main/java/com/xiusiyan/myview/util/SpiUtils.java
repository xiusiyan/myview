package com.xiusiyan.myview.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * SpiUtils
 *
 * @author Raymond
 * @version 1.0, Dec 2, 2009
 * @see
 */
public class SpiUtils {
    private static final Log logger = LogFactory.getLog(SpiUtils.class);

    public static final String SERVICE_ROOT = "META-INF/services/";
    /** @deprecated use {@link #TRANSPORT_SERVICE_PATH */
    @Deprecated
    public static final String PROVIDER_SERVICE_PATH = "";
    public static final String TRANSPORT_SERVICE_PATH = "";
    public static final String EXCEPTION_SERVICE_PATH = "";

}
