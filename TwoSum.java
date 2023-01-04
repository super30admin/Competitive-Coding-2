// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];

            if (map.containsKey(sum)) {
                return new int[]{i, map.get(sum)};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}