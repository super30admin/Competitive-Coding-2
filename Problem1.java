public class TwoSumProblem1 {
// One Pass Hash Table
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		// base case
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		return new int[] { -1, -1 };
	}

}

// Time Complexity : O(n)
// Space Complexity: O(1)
