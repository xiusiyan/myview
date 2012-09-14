package com.xiusiyan.myview.i18n;


import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * MessageFactory
 *
 * @author Raymond
 * @version 1.0, Dec 2, 2009
 * @see
 */
public abstract class MessageFactory {
    /**
     * This error code is used for {@link TraceMessage} instances that are not read from a
     * resource bundles but are created only with a string.
     */
    private static final int STATIC_ERROR_CODE = -1;
    private static final transient Object[] EMPTY_ARGS = new Object[] {};

    protected transient Log logger = LogFactory.getLog(getClass());

    /**
     * Computes the bundle's full path 
     * (<code>META-INF/services/org/mule/i18n/&lt;bundleName&gt;-messages.properties</code>) from
     * <code>bundleName</code>.
     * 
     * @param bundleName Name of the bundle without the &quot;messages&quot; suffix and without
     *          file extension.
     */
    protected static String getBundlePath(String bundleName) {
        return "META-INF.services.org.mule.i18n." + bundleName + "-messages";
    }

    /**
     * Factory method to create a new {@link TraceMessage} instance that is filled with the formatted
     * message with id <code>code</code> from the resource bundle <code>bundlePath</code>.
     * 
     * @param bundlePath complete path to the resource bundle for lookup
     * @param code numeric code of the message
     * @param arg
     * @see #getBundlePath(String)
     */
    protected TraceMessage createMessage(String bundlePath, int code, Object arg) {
        return createMessage(bundlePath, code, new Object[] { arg });
    }

    /**
     * Factory method to create a new {@link TraceMessage} instance that is filled with the formatted
     * message with id <code>code</code> from the resource bundle <code>bundlePath</code>.
     * 
     * @param bundlePath complete path to the resource bundle for lookup
     * @param code numeric code of the message
     * @param arg1
     * @param arg2
     * @see #getBundlePath(String)
     */
    protected TraceMessage createMessage(String bundlePath, int code,
            Object arg1, Object arg2) {
        return createMessage(bundlePath, code, new Object[] { arg1, arg2 });
    }

    /**
     * Factory method to create a new {@link TraceMessage} instance that is filled with the formatted
     * message with id <code>code</code> from the resource bundle <code>bundlePath</code>.
     * 
     * @param bundlePath complete path to the resource bundle for lookup
     * @param code numeric code of the message
     * @param arg1
     * @param arg2
     * @param arg3
     * @see #getBundlePath(String)
     */
    protected TraceMessage createMessage(String bundlePath, int code,
            Object arg1, Object arg2, Object arg3) {
        return createMessage(bundlePath, code,
                             new Object[] { arg1, arg2, arg3 });
    }

    /**
     * Factory method to create a new {@link TraceMessage} instance that is filled with the formatted
     * message with id <code>code</code> from the resource bundle <code>bundlePath</code>.
     * 
     * <b>Attention:</b> do not confuse this method with 
     * <code>createMessage(String, int, Object)</code>.
     * 
     * @param bundlePath complete path to the resource bundle for lookup
     * @param code numeric code of the message
     * @param arguments
     * @see #getBundlePath(String)
     */
    protected TraceMessage createMessage(String bundlePath, int code,
            Object... arguments) {
        String messageString = getString(bundlePath, code, arguments);
        return new TraceMessage(messageString, code, arguments);
    }

    /**
     * Factory method to create a new {@link TraceMessage} instance that is filled with the formatted
     * message with id <code>code</code> from the resource bundle <code>bundlePath</code>.
     * 
     * @param bundlePath complete path to the resource bundle for lookup
     * @param code numeric code of the message
     */
    protected TraceMessage createMessage(String bundlePath, int code) {
        String messageString = getString(bundlePath, code, null);
        return new TraceMessage(messageString, code, EMPTY_ARGS);
    }

    /**
     * Factory method to create a {@link TraceMessage} instance that is not read from a resource bundle.
     * 
     * @param message TraceMessage's message text
     * @return a Messsage instance that has an error code of -1 and no arguments.
     */
    public static TraceMessage createStaticMessage(String message) {
        return new TraceMessage(message, STATIC_ERROR_CODE, EMPTY_ARGS);
    }

    /**
     * Factory method to read the message with code <code>code</code> from the resource bundle.
     * 
     * @param bundlePath complete path to the resource bundle for lookup
     * @param code numeric code of the message
     * @return formatted error message as {@link String}
     */
    protected String getString(String bundlePath, int code) {
        return getString(bundlePath, code, null);
    }

    /**
     * Factory method to read the message with code <code>code</code> from the resource bundle.
     * 
     * @param bundlePath complete path to the resource bundle for lookup
     * @param code numeric code of the message
     * @param arg
     * @return formatted error message as {@link String}
     */
    protected String getString(String bundlePath, int code, Object arg) {
        Object[] arguments = new Object[] { arg };
        return getString(bundlePath, code, arguments);
    }

    /**
     * Factory method to read the message with code <code>code</code> from the resource bundle.
     * 
     * @param bundlePath complete path to the resource bundle for lookup
     * @param code numeric code of the message
     * @param arg1
     * @param arg2
     * @return formatted error message as {@link String}
     */
    protected String getString(String bundlePath, int code, Object arg1,
            Object arg2) {
        Object[] arguments = new Object[] { arg1, arg2 };
        return getString(bundlePath, code, arguments);
    }

    protected String getString(String bundlePath, int code, Object[] args) {
        // We will throw a MissingResourceException if the bundle name is invalid
        // This happens if the code references a bundle name that just doesn't exist
        ResourceBundle bundle = getBundle(bundlePath);

        try {
            String m = bundle.getString(String.valueOf(code));
            if (m == null) {
                logger.error("Failed to find message for id " + code
                        + " in resource bundle " + bundlePath);
                return "";
            }

            return MessageFormat.format(m, args);
        } catch (MissingResourceException e) {
            logger.error("Failed to find message for id " + code
                    + " in resource bundle " + bundlePath);
            return "";
        }
    }

    /**
     * @throws MissingResourceException if resource is missing
     */
    private ResourceBundle getBundle(String bundlePath) {
        Locale locale = Locale.getDefault();
        if (logger.isTraceEnabled()) {
            logger.trace("Loading resource bundle: " + bundlePath
                    + " for locale " + locale);
        }
        ResourceBundle bundle = ResourceBundle.getBundle(bundlePath, locale,
                                                         getClassLoader());
        return bundle;
    }

    /**
     * Override this method to return the classloader for the bundle/module which 
     * contains the needed resource files.
     */
    protected ClassLoader getClassLoader() {
        // Assume the MessageFactory implementation class is in the same module as its resources.
        return getClass().getClassLoader();
    }
}