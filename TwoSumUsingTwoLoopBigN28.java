package com.BigN;

//Time complexity is O(n^2) as two loops are used
//Space complexity is O(n) as we are using additional hashmap
//this solution is submitted on Leetcode

public class TwoSumUsingTwoLoopBigN28 {

	public int[] twoSum(int[] nums, int target) {
		// Edge Case
		if (nums == null || nums.length == 0)
			return new int[] {};
		int len = nums.length;
		// first will fill the hashmap with values
		for (int i = 0; i < len-1; i++) {
			for (int j = i+1; j < len; j++) {
				int sub = target - nums[i];
				if (nums[j] == sub && i != j) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}

	public static void main(String args[]) {
		TwoSumUsingTwoLoopBigN28 tSum = new TwoSumUsingTwoLoopBigN28();
		int target = 32;
		int[] nums = { 2, 7, 11, 15,30 };
		for (int i : tSum.twoSum(nums, target))
			System.out.println(i);

	}

}
