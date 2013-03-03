package com.xiusiyan.hddlog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Utils
 *
 * @author RaymondXiu
 * @version 1.0, 2011-6-18
 * @see
 */
public class Utils {
    public static String readConsole(int index, Boolean isPrettify) throws IOException {
        StringBuffer cmdout = new StringBuffer();
        //        log.info("执行命令：" + cmd); 
        Process process = Runtime.getRuntime().exec("tw_cli /c0/p"+index+" show all"); //执行一个系统命令 
        InputStream fis = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line = null;
        if (isPrettify == null || isPrettify) {
            while ((line = br.readLine()) != null) {
                cmdout.append(line);
            }
        } else {
            while ((line = br.readLine()) != null) {
                cmdout.append(line).append(System.getProperty("line.separator"));
            }
        }
        
        process.destroy();
        //        log.info("执行系统命令后的结果为：\n" + cmdout.toString()); 
        return cmdout.toString().trim();
    }
}
