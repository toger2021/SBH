package com.wj.SBH;

public class SBH {

    public static String hex2BinaryString(String hex){


        return pad(Integer.toBinaryString(Integer.parseInt(hex,16)),8);
    }

    public static String pad(Object str,Integer n){
        if(n==null) n=8;
        Integer len=str.toString().length();
        StringBuffer restr=new StringBuffer(str.toString());
        if(len>=n) return str.toString();

        while(len<n){
            restr.insert(0,"0");
            len++;
        }
        return restr.toString();
    }

    /**
     * @Title:bytes2HexString
     * @Description:字节数组转16进制字符串
     * @param b
     *            字节数组
     * @return 16进制字符串
     * @throws
     */
    public static String bytes2HexString(byte[] b) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            result.append(String.format("%02X",b[i]));
        }
        return result.toString();
    }

    /**
     * @Title:hexString2Bytes
     * @Description:16进制字符串转字节数组
     * @param src
     *            16进制字符串
     * @return 字节数组
     * @throws
     */
    public static byte[] hexString2Bytes(String src) {
        int l = src.length() / 2;
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            ret[i] =  Integer.valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
        }
        return ret;
    }

    /**
     * @Title:string2HexUTF8
     * @Description:字符UTF8串转16进制字符串
     * @param strPart
     *            字符串
     * @return 16进制字符串
     * @throws
     */
    public static String string2HexUTF8(String strPart) {

        return string2HexString(strPart,"UTF-8");
    }

    /**
     * @Title:string2HexUnicode
     * @Description:字符Unicode串转16进制字符串
     * @param strPart
     *            字符串
     * @return 16进制字符串
     * @throws
     */
    public static String string2HexUnicode(String strPart) {

        return string2HexString(strPart,"Unicode");
    }
    /**
     * @Title:string2HexGBK
     * @Description:字符GBK串转16进制字符串
     * @param strPart
     *            字符串
     * @return 16进制字符串
     * @throws
     */
    public static String string2HexGBK(String strPart) {

        return string2HexString(strPart,"GBK");
    }
    /**
     * @Title:string2HexString
     * @Description:字符串转16进制字符串
     * @param strPart 字符串
     * @param tochartype hex目标编码
     * @return 16进制字符串
     * @throws
     */
    public static String string2HexString(String strPart, String tochartype) {
        try{
           return bytes2HexString(strPart.getBytes(tochartype));
        }catch (Exception e){
            return "";
        }
    }

    /**
     * @Title:hexUTF82String
     * @Description:16进制UTF-8字符串转字符串
     * @param src
     *            16进制字符串
     * @return 字节数组
     * @throws
     */
    public static String hexUTF82String(String src) {

        return hexString2String(src,"UTF-8","UTF-8");
    }

    /**
     * @Title:hexGBK2String
     * @Description:16进制GBK字符串转字符串
     * @param src
     *            16进制字符串
     * @return 字节数组
     * @throws
     */
    public static String hexGBK2String(String src) {

        return hexString2String(src,"GBK","UTF-8");
    }

    /**
     * @Title:hexUnicode2String
     * @Description:16进制Unicode字符串转字符串
     * @param src
     *            16进制字符串
     * @return 字节数组
     * @throws
     */
    public static String hexUnicode2String(String src) {
        return hexString2String(src,"Unicode","UTF-8");
    }

    /**
     * @Title:hexString2String
     * @Description:16进制字符串转字符串
     * @param src
     *            16进制字符串
     * @return 字节数组
     * @throws
     */
    public static String hexString2String(String src, String oldchartype, String chartype) {
        byte[] bts=hexString2Bytes(src);
        try{if(oldchartype.equals(chartype))
            return new String(bts,oldchartype);
            else
            return new String(new String(bts,oldchartype).getBytes(),chartype);
        }
        catch (Exception e){

            return"";
        }
    }
}
