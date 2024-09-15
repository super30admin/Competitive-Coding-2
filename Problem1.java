// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//we'll put all values as keys and indices as values in hashmap, then in second iteration, we'll
// search for target-currentnumber in the map where both indices are not same  . if we found the value,
// we'll return the pair of current index and value of key in map
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = { -1, -1 };
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            if (map.containsKey(tar) && i != map.get(tar)) {
                result[0] = map.get(tar);
                result[1] = i;
            }
        }
        return result;
    }
}