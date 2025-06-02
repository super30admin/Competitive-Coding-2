// Approach:
// Use a HashMap to store each number and its index while iterating through the array.
// For each element, compute the complement (target - current value).
// If the complement exists in the map, return the indices.
// Otherwise, store the current number in the map.

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Typo in closing brace at the end (`a`)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];

            // Check if the complement exists in the map
            if (hs.containsKey(x)) {
                return new int[] {i, hs.get(x)};
            }

            // Store the current number and its index
            hs.put(nums[i], i);
        }

        return new int[] {-1, -1}; // Return dummy values if no solution found
    }
}
