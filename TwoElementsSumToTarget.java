// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int compliment = 0;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                res[0] = map.get(compliment);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}