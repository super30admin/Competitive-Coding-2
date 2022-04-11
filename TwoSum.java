// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            
            if(map.containsKey(target - n)) {
                return new int[] {map.get(target-n), i};
            } 
            
            map.put(n, i);
        }
        return new int[] {-1, -1};
    }
}