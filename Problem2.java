/*
 * Problem:
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 */
 
 /*
  * Using a hashmap to efficiently find two indices in nums where the elements sum up to target.
  * It iterates through nums, computing the complement c for each element to check if it exists in the hashmap.
  * If found, it returns the indices {map.get(c), i}; otherwise, it stores the current element and its index in the hashmap.
  * The time complexity is O(n) and space complexity is 
  */
 class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int c = target - nums[i];
            if(map.containsKey(c) && map.get(c)!=i)
            {
                return new int[] {map.get(c), i};
            }
            else{
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No 2 sum solution possible for the given target");
    }
}