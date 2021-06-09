import java.util.HashMap;

// Time Complexity : O(N)
// Space Complexity : O(N) 
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[0] = i;
                result[1] = map.get(diff);
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}