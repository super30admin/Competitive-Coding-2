import java.util.HashMap;

class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                int idx = map.get(diff);
                return new int[] { idx, i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}