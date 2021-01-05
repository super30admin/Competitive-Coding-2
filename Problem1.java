//The Two sum solution
//Space Complexity is O(n)
//Time Compplexity is O(n)
package TestPackage;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3 };
		int target = 6;
		System.out.println(Arrays.toString(twoSum(nums, target)));

	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			hash.put(nums[i], i);
		}
		int element = 0;
		for (int i = 0; i < nums.length; i++) {
			element = target - nums[i];
			if (hash.containsKey(element)) {
				if (i != hash.get(element)) {
					return new int[] { i, hash.get(element) };
				}
			}

		}
		return new int[] { -1, -1 };
	}

}
