// 2 - sum Problem

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            map.put(nums[i], i);
        }
        
        for(int i = 0; i< nums.length; i++){
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                return new int[]{map.get(target - nums[i]), i };
            }
        }
        
        return new int[]{-1,-1};
    }
}