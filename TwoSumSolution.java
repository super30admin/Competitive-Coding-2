// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;
class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();        
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};       
    }
}