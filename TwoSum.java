// TC: O (n)
// SC : O (n)

import java.util.HashMap;
import java.util.Map;

/*
 * For each element, check if the corresponding target - elem
 * exists. To do this efficiently, store each element in a hashmap (along with its index)
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) return new int[]{-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}