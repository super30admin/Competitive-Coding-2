//TC: O(N) SC: O(N)
//https://leetcode.com/problems/two-sum/description/

import java.util.HashMap;
import java.util.Map;

class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapper = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            Integer diff = target - nums[i];
            if(mapper.containsKey(diff)) {
                return new int[] {i, mapper.get(diff)};
            }
            mapper.put(nums[i], i);
        }
        return null;
    }
}