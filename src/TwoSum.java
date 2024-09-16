import java.util.HashMap;
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class TwoSum {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            for(int i=0; i<nums.length; i++) {
                if(!hash.containsKey(nums[i])) {
                    hash.put(target-nums[i], i);
                }
                else {
                    return new int[]{hash.get(nums[i]), i};
                }
            }
            return nums;
        }

}
