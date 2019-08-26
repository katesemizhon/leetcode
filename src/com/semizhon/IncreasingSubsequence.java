package com.semizhon;

public class IncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int currentSubsequenceLength = 0;
        int longestSubsequenceLength = 0;
        int prev = 0;
        if (nums.length > 0) {
            prev = nums[0];
            currentSubsequenceLength = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) {
                currentSubsequenceLength++;
            } else {
                if (currentSubsequenceLength > longestSubsequenceLength) {
                    longestSubsequenceLength = currentSubsequenceLength;
                }
                currentSubsequenceLength = 1;
            }
            prev = nums[i];
        }

        return currentSubsequenceLength > longestSubsequenceLength ? currentSubsequenceLength : longestSubsequenceLength;
    }
}
