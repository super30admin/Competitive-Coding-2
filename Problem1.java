// TC: O(n)
// SC: O(n)
// Solved in LC
// Link: https://leetcode.com/problems/two-sum/description/

import java.util.*;

class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int newTarget = target - nums[i];
            if (map.containsKey(newTarget)) {
                return new int[] { i, map.get(newTarget) };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}