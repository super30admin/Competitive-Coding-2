// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

import java.util.HashMap;

/**
 * Take a hashmap to store current number with its index. Iterate
 * each index and check if the difference of target and that number
 * is present in the map. If so, return the indices, else put the
 * index of current number in the map. If nothing found, then
 * return -1,-1 array.
 *
 */
class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (map.containsKey(diff)) {
				return new int[] { map.get(diff), i };
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[] { -1, -1 };
	}
}