// Problem: https://leetcode.com/problems/two-sum/
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numMap.containsKey(diff)) {
                return new int[] { i, numMap.get(diff) };
            } else {
                numMap.put(nums[i], i);

            }

        }
        return null;
    }
}