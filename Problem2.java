/**
 * https://leetcode.com/problems/two-sum/
 * Time complexity :O(n)
 * Space complexity: O(n)
 * n is total number of elements in array
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}