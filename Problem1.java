import java.util.*;

class Solution {

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Did this code successfully run on Leetcode : Yes

    // Your code here along with comments explaining your approach
    /*
    1. Store the value of number and its index position.
    2. While traversing through the array check is (target - num) exists in the map.
    3. If it exists, return the index position of number and value from the map for the key of (target - num)
    */
    public int[] twoSum(int[] nums, int target) {
        
        if(nums == null || nums.length == 0)
            return new int[]{};
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[]{};
        
    }
}