// Problem 1: 

// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, tried the brute force first


// Your code here along with comments explaining your approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[0];
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length && j != i; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[0];
    }
}


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[0];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i) {
                return new int[] {i, map.get(complement)};
            }
        }
        return new int[0];
    }
}