import java.util.Map;
import java.util.HashMap;

/**
 * Two Sum:
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice.
 * 
 * Space Complexity : O(n) 
 * Time Complexity : O(n)
 * 
 * Leetcode Result: Runtime: 2 ms, faster than 98.86% of Java online submissions
 * for Two Sum. Memory Usage: 37.3 MB, less than 98.95% of Java online
 * submissions for Two Sum.
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map map = new HashMap<Integer, Integer>();
        // we would store complement of a number and its index(because we want to return
        // index)
        int c;

        for (int i = 0; i < nums.length; i++) {
            c = target - nums[i]; // complement
            if (map.containsKey(c)) {
                // found indicates nums[i] + t == target, so return index
                return new int[] { (int) map.get(c), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}