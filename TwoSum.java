import java.util.HashMap;
import java.util.Map;

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