package com.xiusiyan.hddlog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * HDDTemp
 *
 * @author RaymondXiu
 * @version 1.0, 2011-6-18
 * @see
 */
public class HDDTemp {
    

    public static void main(String[] args) throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("MM/dd HH:mm:ss");
        BufferedWriter output  = null;
        File f = null;
        String path = System.getProperty("user.dir")+ File.separator + "hddtemp.log";
        
        try {
            System.out.println("file:" + path);
            f = new File(path);
            output = new BufferedWriter(new FileWriter(f));
            
            output.write("Time,P8,P9,P12,P13,P14,P15\r\n");
            for (;;) {
                output.write( df.format(new Date())+ ","+ getTemp(8)+ ","+ getTemp(9)+ ","+ getTemp(12)+ ","+ getTemp(13)+ ","+ getTemp(14)+ ","+ getTemp(15)+"\r\n");
                output.flush();
                Thread.sleep(60000);
            }
            
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            output.close();
        }
       
        
   }

    
    public static int getTemp(int index) throws IOException{
        String output = null;
        output = Utils.readConsole(index, false);
        HDDStatInfo hddInfo = new HDDStatInfo(index,output);
        
        return hddInfo.temperature;
    }
}
