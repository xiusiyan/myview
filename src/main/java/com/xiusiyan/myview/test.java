package com.xiusiyan.myview;

/**
 * test
 *
 * @author xiusiyan
 * @version 1.0, Jun 4, 2012
 * @see
 */
public class test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        byte[] b1 = getAsciiBytes("family");
        byte[] b2 = getAsciiBytes("you and me");
        byte[] b3 = getAsciiBytes("future");
        byte[] b4 = getAsciiBytes("coming");
        
        print(b1);
        print(b2);
        print(b3);
        print(b4);
        
        test();
    }
    
    public static byte[] getAsciiBytes(String input)
    {
      char[] c = input.toCharArray();
      byte[] b = new byte[c.length];
      for (int i = 0; i < c.length; i++)
        b[i] = (byte)(c[i] & 0x007F);

      return b;
    }
    public static void print(byte[] byteArrays){
        int length = byteArrays.length;
        StringBuffer strBuff = new StringBuffer();
        
        strBuff.append("System.out.printf(\"");
        
        for(int i=0;i<length;i++){
            strBuff.append("%c");
        }
        strBuff.append("\\n\",");
        for(int i=0;i<length;i++){
            strBuff.append(byteArrays[i]);
            if(i!=length-1){
                strBuff.append(",");   
            }
        }
        
        strBuff.append(");");
        
        
        System.out.println(strBuff.toString());
    }


    public static void test(){
        System.out.printf("%c%c%c%c%c%c\n",102,97,109,105,108,121);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c\n",121,111,117,32,97,110,100,32,109,101);
        System.out.printf("%c%c%c%c%c%c\n",102,117,116,117,114,101);
        System.out.printf("%c%c%c%c%c%c\n",99,111,109,105,110,103);

    }
}
