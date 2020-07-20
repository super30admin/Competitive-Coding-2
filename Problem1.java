// Time Complexity :O(n)
//      n: number of elements
// Space Complexity :O(n)
//      n: number of elements (for HashMap)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

import java.util.HashMap;

class Problem1 {

    /** find index of two integers whose sum equals to target */
    public int[] twoSum(int[] nums, int target) {
        
        // hashmap which stores complement and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // iterate
        for(int i=0; i<nums.length; i++){
            
            int value = nums[i];
            int complement = target-value;
    
            // if value already present in hashmap
            if(map.containsKey(value))
                return new int[]{i, map.get(value)};
            else
            // store which value requires the complement
                map.put(complement, i); 
            
        }

        // not found
        return new int[]{-1, -1};
    }
}