package com.semizhon;

import java.util.*;

public class ThreeSums {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> resultStringSet = new HashSet<String>();

        boolean skipNext = false;
        for (int i = 1; i < nums.length; i++) {

            int k = nums.length - 1;
            int j = 0;
            while (j < i && k > i) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    if ((j > 0 && nums[j] != nums[j-1] || j == 0) && (k < nums.length - 1 && nums[k] != nums[k+1] || k == nums.length - 1)) {
                        StringBuilder str = new StringBuilder();

                        List<Integer> newResult = new ArrayList<Integer>();
                        newResult.add(nums[i]);
                        newResult.add(nums[j]);
                        newResult.add(nums[k]);
                        Collections.sort(newResult);

                        for (Integer integer : newResult) {
                            str.append(integer);
                        }

                        if (!resultStringSet.contains(str.toString())) {
                            result.add(newResult);
                            resultStringSet.add(str.toString());
                        }


                    }
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
            }
        }


        return result;




    }

    public static void main (String[] args) {
        new ThreeSums().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
    }
}
