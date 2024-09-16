// Two Sum
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> comp = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(comp.containsKey(target-nums[i])) {
                return new int [] {i, comp.get(target-nums[i])};
            }
            comp.put(nums[i],i);
            
        } 
        
        throw new IllegalArgumentException("No solution");
        
    }
}


