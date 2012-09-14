package com.xiusiyan.myview;

import java.io.IOException;

import com.xiusiyan.myview.i18n.TraceMessage;

/**
 * MyViewRuntimeException
 *
 * @author xiusiyan
 * @version 1.0, Sep 11, 2012
 * @see
 */
public class MyViewRuntimeException extends RuntimeException {

    public MyViewRuntimeException(TraceMessage message) {
        super(message.getMessage());
    }

    public MyViewRuntimeException(TraceMessage message, Throwable cause) {
        super(message.getMessage(), cause);
    }

}
