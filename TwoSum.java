import java.util.HashMap;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		if (nums.length == 0 || nums == null) {
			return new int[] { -1, -1 };
		}

		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int diff = 0;
		for (int i = 0; i < nums.length; i++) {
			diff = target - nums[i];

			if (map.containsKey(diff) && map.get(diff) != i) {
				return new int[] { map.get(diff), i };
			}
		}

		return new int[] { -1, -1 };

	}
}
