// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            // check if map contains target - num, then return index
            if(map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {-1, -1};
    }
}