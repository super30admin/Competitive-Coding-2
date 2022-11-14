import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // space complexity => O(n)
        // time complexity = o(n)

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }

            else {
                map.put(nums[i], i);
            }
        }

        return new int[] {};

    }
}