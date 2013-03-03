package com.xiusiyan.hddlog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * HDDStat
 *
 * @author RaymondXiu
 * @version 1.0, 2011-6-18
 * @see
 */
public class HDDStat {
    static List<HDDStatInfo> stats = new ArrayList<HDDStatInfo>();

    public static void main(String[] args) throws Exception {
        
        String path = System.getProperty("user.dir") + File.separator + "hddtemp.log";
        
        for(;;){
        initHDDstatInfo();
        
        writeLog(path);
        Thread.sleep(10000);
        }
//        //Debug
//        for (HDDStatInfo hddInfo : stats) {
//            System.out.println(hddInfo);
//        }

    }

    /**
     * @param path
     * @throws IOException
     */
    private static void writeLog(String path) throws IOException {
        BufferedWriter output = null;
        File f = null;
        StringBuffer tmp = new StringBuffer();

        try {
            System.out.println("file:" + path);
            f = new File(path);

            //Head Row
            if (!f.exists()) {
                tmp.append(doHeadRow());
            }
            //Detail Row
            tmp.append(doDetailRow());

            output = new BufferedWriter(new FileWriter(f, true));
            output.write(tmp.toString());

            output.flush();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            output.close();
        }
    }

    /**
     * @throws IOException
     */
    private static void initHDDstatInfo() throws IOException {
        String console_out = null;
        
        stats.clear();
        for (int i = 0; i < 16; i++) {
            console_out = Utils.readConsole(i, false);
            HDDStatInfo hddInfo = new HDDStatInfo(i, console_out);

            if (hddInfo.status != null) {
                stats.add(hddInfo);
            }

        }
    }

    /**
     * @param output
     * @param tmp
     * @throws IOException
     */
    private static StringBuffer doHeadRow() throws IOException {
        StringBuffer tmp = new StringBuffer();
        
        tmp = new StringBuffer("Time,");
        for(HDDStatInfo hddInfo : stats){
            tmp.append("P" + hddInfo.portIndex+",");
        }
        tmp.delete(tmp.lastIndexOf(","), tmp.lastIndexOf(",")+1);
        tmp.append("\r\n");

        return tmp;
    }

    /**
     * @param df
     * @return
     */
    private static StringBuffer doDetailRow() {
        StringBuffer tmp = new StringBuffer();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd HH:mm:ss");
        
        tmp.append( df.format(new Date())+ ",");
        for(HDDStatInfo hddInfo : stats){
            tmp.append(hddInfo.temperature + "," );

        }
        tmp.delete(tmp.lastIndexOf(","), tmp.lastIndexOf(",")+1);
        tmp.append("\r\n");
        
        return tmp;
    }
}
