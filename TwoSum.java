import java.util.HashMap;
import java.util.Map;

// TC - O(N)
// SC - O(N)

// Constraints:
// 2 <= nums.length <= 10^4
// -10^9 <= nums[i] <= 10^9
// -10^9 <= target <= 10^9
// Only one valid answer exists.

public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] result = new int[] { -1, -1 };
            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];
                int requiredNum = target - curr;
                if (map.containsKey(requiredNum)) {
                    result[0] = map.get(requiredNum);
                    result[1] = i;
                    return result;
                }
                map.put(curr, i);
            }
            return result;
        }
    }
}