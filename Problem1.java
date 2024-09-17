import java.util.HashMap;

/**
 * Using HashMap to store nums and their indices, and verifying the difference exists at every step
 * Time: O(n)
 * Space: O(n)
 * Leetcode accepted: yes
 * Problems faced: NA
 */

public class Problem1 {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			if(!hm.containsKey(target-nums[i])) {
				hm.put(nums[i], i);
			} else {
				result[1] = i;
				result[0] = hm.get(target-nums[i]);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] nums = {1, 7, 11, 2};
		int target = 9;
		System.out.println(twoSum(nums, target)[0] + " " + twoSum(nums, target)[1]);
	}
}
