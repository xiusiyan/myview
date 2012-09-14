package com.xiusiyan.myview.util;

import java.io.File;
import java.io.IOException;

import com.xiusiyan.myview.MyViewRuntimeException;
import com.xiusiyan.myview.i18n.MessageFactory;

/**
 * FileUtils
 *
 * @author Raymond
 * @version 1.0, Dec 2, 2009
 * @see
 */
public class FileUtils extends org.apache.commons.io.FileUtils {
    public static File newFile(String pathName) {
        try {
            return new File(pathName).getCanonicalFile();
        } catch (IOException e) {
            throw new MyViewRuntimeException(
                    MessageFactory
                            .createStaticMessage("Unable to create a canonical file for "
                                    + pathName), e);
        }
    }
}
