/**
 * Problem Statement: Two Sum
 * 
 * An array is given in the question and you need to return the indices of two numbers such that they add up to a specific target. assume that there is only one solution for each input and you cannot use the same element twice. 

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
Source Link: https://leetcode.com/problems/two-sum/

 */

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Approach:
 * we are using HashMap to store the current value and its index in the hashmap.
 * for every element, we check if (target - element) exists in the hashmap, we have found a pair and we return the two indices.
**/

class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        
        // value --> index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0;i<nums.length;i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        
        return new int[]{-1, -1};
    }
}