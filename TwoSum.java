// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;
import java.util.HashMap;

class TwoSum {
	/*
	 * In this function we create a hashmap of key and value as Integer, and then we
	 * iterate through the nums array and we first check if the difference between
	 * the target and the current nums element is present in the HashMap, if it is
	 * present we simply return the indices, else we put the key as the nums element
	 * and value as the index of nums element into the hashmap.
	 */
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (hmap.containsKey(complement)) {
				return new int[] { hmap.get(complement), i };
			} else {
				hmap.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No Two Sum Found");
	}

	public static void main(String[] args) {
		int nums[] = { 2, 5, 9, 11 };
		int target = 7;
		int res[] = twoSum(nums, target);
		System.out.println(Arrays.toString(res));
	}
}