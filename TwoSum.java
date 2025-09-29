
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return new int[] {-1, -1};
        }
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (valueToIndexMap.containsKey(target - nums[i])) {
                return new int[] {i, valueToIndexMap.get(target - nums[i])};
            }
            valueToIndexMap.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}