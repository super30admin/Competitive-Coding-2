// TC: O(n)
// SC: O(n)

import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        int d = 0;
        for (int i = 0; i < nums.length; i++) {
            d = target - nums[i];
            if (map.containsKey(d)) {
                res[0] = map.get(d);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}