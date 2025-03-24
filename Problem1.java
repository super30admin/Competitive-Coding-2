// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Approach:
//Used Hashmap to store values and their indices while traversing through array.
//If complement exists in the hashmap, returns the index of complement and current number from the given array.


import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int comp=target-nums[i];
            if(map.containsKey(comp)){
                return new int[]{map.get(comp),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}

