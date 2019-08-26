package com.semizhon;

import static org.junit.Assert.*;
import  com.semizhon.ReverseVowels;


public class ReverseVowelsTest {

    @org.junit.Test
    public void  reverseVowelsTest() {
        ReverseVowels rev = new ReverseVowels();
        assertEquals("holle", rev.reverseVowels("hello"));
        assertEquals("leotcede", rev.reverseVowels("leetcode"));
        assertEquals("freind", rev.reverseVowels("friend"));
        assertEquals("yes", rev.reverseVowels("yes"));
        assertEquals("wee", rev.reverseVowels("wee"));
        assertEquals("ia", rev.reverseVowels("ai"));
        assertEquals("euston saw I was not SuE.", rev.reverseVowels("Euston saw I was not Sue."));


    }
}