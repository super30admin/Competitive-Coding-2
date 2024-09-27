// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
Approach:
=========
1. Use auxilliary hashmap to store [value,index] pairs. 
2. If target - nums[i] not found in map, store this value and index in map
3. If found, return indices of both nums[i] and difference
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer>  visitedMap= new HashMap<>(); //map to store [value, index] pairs

        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i]; 
            if(visitedMap.containsKey(diff)) //if diff exists in map, 2sum found
                return new int[]{visitedMap.get(diff),i}; //return indices of diff and nums[i]
            visitedMap.put(nums[i],i); //if not found, store [nums[i],i] in map
        }
        return new int[]{-1,-1}; //pair not found
    }
}