import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (map.containsKey(diff)) {
                int first = map.get(diff);
                return new int[] { first, i };
            }
            map.put(nums[i], i);
        }

        return new int[] { -1 };

    }
}