import java.util.HashMap;
//Time Complexity : O(n)  n is the length of nums
//Space Complexity : O(n) n is the length of nums
// Did this code successfully run on Leetcode : Yes
//Approach :
/*
 * We use hashmap for fast lookup and store current nums[i] as key and index as value. We iterate over for look to
 * check if target - current is present in map and return indices of pair which is adding up to target.
 * Else return -1,-1.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 1) {
            return new int[]{-1,-1};
        } 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
