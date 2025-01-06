//Problem -1
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]

//Solution:
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Base Condition check
        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }
        //Hashmap initialization
        HashMap<Integer,Integer> map=new HashMap<>();
        //Iteration through each element of nums
        for(int i=0;i<nums.length;i++){
            //If map contains target-nums[i]) then that value and the current index is the answer
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

}