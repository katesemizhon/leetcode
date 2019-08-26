package com.semizhon;

import static com.semizhon.ReverseInteger.romanToInt;
import static org.junit.Assert.*;

public class ReverseIntegerTest {
    @org.junit.Test
    public void romanToIntTest() throws Exception {
       assertEquals(1, romanToInt("I"));

        assertEquals(2, romanToInt("II"));
        assertEquals(3, romanToInt("III"));
        assertEquals(4, romanToInt("IV"));
        assertEquals(6, romanToInt("VI"));
        assertEquals(8, romanToInt("VIII"));
        assertEquals(19, romanToInt("XIX"));
        // 44= XLIV
        assertEquals(44, romanToInt("XLIV"));

        assertEquals(80, romanToInt("LXXX"));
        assertEquals(111, romanToInt("CXI"));
        assertEquals(188, romanToInt("CLXXXVIII"));
        assertEquals(285, romanToInt("CCLXXXV"));

        assertEquals(285, romanToInt("CCLXXXV"));
        assertEquals(285, romanToInt("CCLXXXV"));
        assertEquals(339, romanToInt("CCCXXXIX"));
        assertEquals(788, romanToInt("DCCLXXXVIII"));
        assertEquals(1038, romanToInt("MXXXVIII"));
        assertEquals(1278, romanToInt("MCCLXXVIII"));
        assertEquals(1678, romanToInt("MDCLXXVIII"));
        assertEquals(1929, romanToInt("MCMXXIX"));
        assertEquals(2787, romanToInt("MMDCCLXXXVII"));
        assertEquals(1181, romanToInt("MCLXXXI"));

    }

}