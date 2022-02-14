// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: created a hashmap with target - num[i] as key and value
// as i. Every iteration (j), check if complement exists, if it does,
// return j and value at target-nums[j]. else add it to the map.

import java.util.HashMap;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (map.containsKey(nums[i])) {
        return new int[] { i, map.get(nums[i]) };
      } else {
        map.put(complement, i);
      }
    }

    return new int[] { -1, -1 };
  }
}
