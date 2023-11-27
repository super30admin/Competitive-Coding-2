// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/two-sum/
// Any problem you faced while coding this : -

import java.util.HashMap;
import java.util.Map;

/*
Problem::: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
Solution::: Use hashmap to save nums and their indicies. Iterate through the elements and check each of the complements in map.
If a complement is available in map, add to the result array   */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hMap = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            if(hMap.containsKey(target - nums[i]))
                return new int[]{i, hMap.get(target - nums[i])};
            else
                hMap.put(nums[i], i);
        }
        return new int[]{};
    }
}