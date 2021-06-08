// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this : None

// The basic idea is to store the complement of the target and current number along with its index in a Hashmap
// amd return when the pair of indices when the complement is found in the hashmap 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums== null || nums.length == 0)
            return new int[]{-1,-1};
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{-1,-1};
            
    }
}
