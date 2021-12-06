// 2 Sum
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1,-1};
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                int j = map.get(target-nums[i]);
                return new int[]{i, j};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1,-1};
    }
}