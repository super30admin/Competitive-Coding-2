// Time Complexity : O(N) , 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this


/*
 * This problem was asked at Amazon
 * 
 * an array is given in the question and you need to return the indices of two
 * numbers such that they add up to a specific target. assume that there is only
 * one solution for each input and you cannot use the same element twice.
 * 
 * 
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * 
 * 
 * 
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * 
 * 
 * 
 * return [0, 1].
 */


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> h = new HashMap<>();
        
        for(int i =0;i<nums.length;i++){
            h.put(nums[i],i);
        }
        
        for(int i =0;i<nums.length;i++){
            int complement = target - nums[i]; 
            if(h.containsKey(complement)  && h.get(complement) != i){
                return new int[] {i,h.get(complement)};
            }
        }
        
        return new int[] {-1,-1};
    }
}