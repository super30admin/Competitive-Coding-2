/**
Problem 1: Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 
Time Complexity :   O (n) 
Space Complexity :  O (n) 
Did this code successfully run on Leetcode :    Yes (1. Two Sum)
Any problem you faced while coding this :       No
 */

import java.util.HashMap;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i< nums.length; i++){
            // check if number is there in Hashmap
            if(!map.containsKey(nums[i])){
                // if not present, then calculate the complement and store into hashmap
                int rem = target - nums[i];
                map.put(rem, i);     
            }else{
                // return the current number index and complements index
                return new int[]{map.get(nums[i]), i};
            }
        }
        // No 2 numbers found, then return {-1, -1}
        return new int[]{-1, -1};
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.print(res[0]+" "+res[1]);
    }
}