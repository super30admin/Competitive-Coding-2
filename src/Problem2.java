/*
Problem - Two Sum (Leet Code 1)
Approach - •
•Loop through the array and for each number, compute the difference from the target.
•If the complement is already in the map, return its index and the current one.
•Otherwise, store the number with its index for future checks.
Time Complexity O(n)
Space Complexity O(n)
 */

import java.util.HashMap;

class Problem2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{ map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; // guaranteed solution exists, so this won't run
    }
}
