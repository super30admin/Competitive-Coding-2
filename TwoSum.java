// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Getting started

// Your code here along with comments explaining your approach

import java.util.HashMap;

public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < nums.length; i++){

                int sum = target - nums[i];

                if(map.containsKey(sum)){
                    return new int[] {map.get(sum), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }
}
