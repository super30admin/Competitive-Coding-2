// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); // creating the hashmap
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i ) { // has the required difference to make up the sum
                return new int[] { map.get(target - nums[i]), i };
            } else {
                map.put(nums[i], i); // adding to the hashmap
            }
        }

        return new int[] { -1, -1 };

    }
}