// Time Complexity : O(n) --> where n is size of input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (1) : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment) && map.get(compliment) != i) return new int[]{i, map.get(compliment)};
        }
        return new int[]{-1, -1};
    }
}