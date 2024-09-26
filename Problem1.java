/* -------------------------------------- TWO SUM -------------------------------------- */
// Time Complexity : O(n), n -> arr.length
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
	public int[] twoSum(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return new int[] { -1, -1 };
		}
		int[] ans = new int[] { -1, -1 };
		Map<Integer, Integer> arrMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (arrMap.containsKey(target - arr[i])) {
				ans[0] = arrMap.get(target - arr[i]);
				ans[1] = i;
				return ans;
			}
			arrMap.put(arr[i], i);
		}
		return ans;
	}

	public static void main(String[] args) {
		Problem1 obj = new Problem1();
		int[] arr = new int[] { 2, 11, 7, 9 };
		int target = 9;
		int[] twoSumPair = obj.twoSum(arr, target);
		System.out.println("Two sum pairs: " + twoSumPair[0] + ", " + twoSumPair[1]);
	}
}