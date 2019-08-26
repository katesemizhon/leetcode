package com.semizhon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IncreasingSubsequenceTest {
  @Test
  public void findLengthOfLCISTest() throws Exception {
    IncreasingSubsequence test = new IncreasingSubsequence();
    assertEquals(3, test.findLengthOfLCIS(new int[] {1, 3, 5, 4, 7}));
    assertEquals(2, test.findLengthOfLCIS(new int[] {7, 3, 5, 4, 1}));
    assertEquals(1, test.findLengthOfLCIS(new int[] {2, 2, 2, 2, 2}));
  }
}
