// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach

import java.util.*;

class TwoSum {
    private static int[] findTarget(int nums[], int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            // Check if the difference is present in the hashmap
            if (hmap.containsKey(diff)) {
                return new int[] { i, hmap.get(diff) };
            }
            // if not present insert the element in the hashmap along with its index
            hmap.put(nums[i], i);

        }
        return new int[] { -1, -1 };
    }

    public static void main(String args[]) {
        int[] nums = new int[] { 2, 7, 11, 5 };
        int target = 9;
        int[] result = new int[2];
        result = findTarget(nums, target);
        System.out.println(Arrays.toString(result));

    }
}
