// Time Complexity : O(N)
// Space Complexity : O(N)

// Your code here along with comments explaining your approach
// We need to find 2 variables (a and b) that sum to Target T. I will use hashmap to store values(a) and search
// for T-b in hashmap. If the value exists, it means a pair (a,b) exists in map that sums up to T, else no such
// pair exists.

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> pairs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer cIndex = pairs.getOrDefault(complement, null);
            if (cIndex == null) {
                pairs.put(nums[i], i);
            } else {
                result[0] = cIndex;
                result[1] = i;
            }

        }

        return result;
    }

}
