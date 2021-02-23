package com.wj.SBH;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SBHTest {



    @Test
    void hex2BinaryString2(){
        assertEquals("11111111",SBH.hex2BinaryString("ff"));
        assertEquals("00000000",SBH.hex2BinaryString("00"));
        assertEquals("00000001",SBH.hex2BinaryString("01"));
        assertEquals("00111010",SBH.hex2BinaryString("3a"));
    }

    @Test
    void string2HexUTF8() throws Exception{
        Character a = '我';
        byte[]  bys=a.toString().getBytes("UTF-8");
        assertEquals(
                String.format("%02X",bys[0])
                        + String.format("%02X",bys[1])
                        + String.format("%02X",bys[2])
                ,SBH.string2HexUTF8(a.toString()));
    }

    @Test
    void string2HexUnicode() throws Exception{
        Character a = '我';
        byte[] bys=a.toString().getBytes("Unicode");
        assertEquals(
                String.format("%02X",bys[0])
                        + String.format("%02X",bys[1])
                        + String.format("%02X",bys[2])
                        + String.format("%02X",bys[3])
                ,SBH.string2HexUnicode(a.toString()));
    }

    @Test
    void string2HexGBK() throws Exception {

        // 单字符转gbk16进制编码
        Character a = '我';

        byte[] bys = a.toString().getBytes("GBK");

        assertEquals("CE", String.format("%02X",bys[0]));//02 表示不足两位,，前面补0输出，如果超过两位，则以实际输出
        assertEquals("D2",String.format("%02X",bys[1]));

        assertEquals(
                String.format("%02X",bys[0])
                        +String.format("%02X",bys[1]),
                SBH.string2HexGBK(a.toString()));
    }

    @Test
    void hexUTF82String() {
        String c="**提示:终端已处于断油电状态，本指令不再执行!";
        String hexcUtf8="2A2AE68F90E7A4BA3AE7BB88E7ABAFE5B7B2E5A484E4BA8EE696ADE6B2B9E794B5E78AB6E68081EFBC8CE69CACE68C87E4BBA4E4B88DE5868DE689A7E8A18C21";

        assertEquals(hexcUtf8,SBH.string2HexUTF8(c));
        assertEquals(c,SBH.hexUTF82String(hexcUtf8));
    }

    @Test
    void hexGBK2String() {
        String c="**提示:终端已处于断油电状态，本指令不再执行!";
        String hexcgbk="2A2ACCE1CABE3AD6D5B6CBD2D1B4A6D3DAB6CFD3CDB5E7D7B4CCACA3ACB1BED6B8C1EEB2BBD4D9D6B4D0D021";

        assertEquals(hexcgbk,SBH.string2HexGBK(c));
        assertEquals(c,SBH.hexGBK2String(hexcgbk));
    }

    @Test
    void hexUnicode2String() {
        String c="**提示:终端已处于断油电状态，本指令不再执行!";
        String hexcunicode="FEFF002A002A63D0793A003A7EC87AEF5DF259044E8E65AD6CB9753572B66001FF0C672C63074EE44E0D518D6267884C0021";

        assertEquals(hexcunicode,SBH.string2HexUnicode(c));
        assertEquals(c,SBH.hexUnicode2String(hexcunicode));
    }
}