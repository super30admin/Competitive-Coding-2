import java.util.*;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        if (nums == null || nums.length == 0)   return new int[] {-1, -1};
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int second = target - nums[i];
            if(map.containsKey(second) && map.get(second) != i){
                return new int[] {map.get(second), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}