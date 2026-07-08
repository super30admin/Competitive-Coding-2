// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : difficult to come up with the approach of using hashmap to store the values and their indices.
// Your code here along with comments explaining your approach: hashmap is used to store the values and their indices. In the first loop, we store all the values and their indices in the hashmap. In the second loop, we check if the complement of the current value (target - current value) exists in the hashmap and if it does, we return the indices of the two values.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int cmp = target - nums[i];
            if (map.containsKey(cmp) && map.get(cmp) != i) {
                return new int[]{map.get(cmp),i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}