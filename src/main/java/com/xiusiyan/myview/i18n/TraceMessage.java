package com.xiusiyan.myview.i18n;


import java.io.Serializable;

/**
 * ExceptionMessage
 *
 * @author Raymond
 * @version 1.0, Dec 2, 2009
 * @see
 */
public class TraceMessage implements Serializable {
    /**
     * Serial version
     */
    private static final long serialVersionUID = -6109760447384477924L;

    private final String message;
    private int code = 0;
    private final Object[] args;
    private TraceMessage nextMessage;

    protected TraceMessage(String message, int code, Object... args) {
        super();
        this.message = message;
        this.code = code;
        this.args = args;
    }

    public int getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getMessage() {
        return message
                + (nextMessage != null ? ". " + nextMessage.getMessage() : "");
    }

    public TraceMessage setNextMessage(TraceMessage nextMessage) {
        this.nextMessage = nextMessage;
        return this;
    }

    public TraceMessage getNextMessage() {
        return nextMessage;
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
