package com.semizhon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class WordBreakTest {
    @Test
    public void wordBreakTest() throws Exception {
        assertEquals(true, new WordBreak().wordBreak2("leetcode", new ArrayList<String>(Arrays.asList(new String[]{"leet", "code"}))));
        assertEquals(true, new WordBreak().wordBreak2("a", new ArrayList<String>(Arrays.asList(new String[]{"a", "code"}))));
        assertEquals(true, new WordBreak().wordBreak2("abcd", new ArrayList<String>(Arrays.asList(new String[]{"a", "abc", "b", "cd"}))));
        assertEquals(false, new WordBreak().wordBreak2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", new ArrayList<String>(Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}))));
        assertEquals(true, new WordBreak().wordBreak2("bb", new ArrayList<String>(Arrays.asList(new String[]{"a","b","bbb","bbbb"}))));

    }

}