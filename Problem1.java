// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> c = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(c.containsKey(target-nums[i])) {
                return new int [] {i, c.get(target-nums[i])};
            }
            c.put(nums[i],i);

        } 

        throw new IllegalArgumentException("No solution");

    }
}