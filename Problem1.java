// Time complexity: O(N), where N is the length of nums array. 
// Space complexity: O(N). 

import java.util.*;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 1) return new int[]{-1,-1}; 
        
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // if the map contains key complement return the output.
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};  
            }
            else {
                // put the element in the map with index as value.
                map.put(nums[i], i); 
            }
        }
        
        return new int[]{-1,-1}; 
    }
}