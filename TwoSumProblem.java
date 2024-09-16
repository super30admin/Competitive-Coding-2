// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english - keep current number and index in hashmap, check for complement of current number
// and target in the map, that is our answer pair

/**https://leetcode.com/problems/two-sum/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i< nums.length; i++) {
            
            int diff = target - nums[i];
            
            if(map.containsKey(diff)) {
               return new int[] {i, map.get(diff)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}