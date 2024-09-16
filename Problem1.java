// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/* Get the complement i.e target- nums[i], check if it exists in the map or else put  the number and corresponding indices in map */
// Your code here along with comments explaining your approach
/*
Get the complement i.e target- nums[i], check if it exists in the map or else put  the number and corresponding indices in map
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}