package com.xiusiyan.myview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utils
 *
 * @author xiusiyan
 * @version 1.0, 2012-7-27
 * @see
 */
public class Utils {
    public static String pumpString(String path) throws Exception{
        String line;
        StringBuffer buffer = new StringBuffer();

        Utils.class.getResourceAsStream(path);
        new File(path).exists();
        InputStream is = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine();
        while (line != null) {            
            buffer.append("System.out.println(\"" + line + "\");\n");
            line = reader.readLine();
        }
        
        
        return buffer.toString();
    }
}