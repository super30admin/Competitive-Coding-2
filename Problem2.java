import java.util.*;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ans = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            ans.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            
            if (ans.containsKey(res) && ans.get(res) != i) {
                int j = ans.get(res);
                return new int[] {i, j};
            }
        }
        return new int[] {0};
    }
}
