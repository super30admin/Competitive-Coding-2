 //Time complexity: O(n)
//Space complexity: O(n)

/* Using HashMap
Check whether the map contains a key, i.e if we subtract the every number by target, then we will be finding the two indices required */

import java.util.*;

public class Problem1 {
	public static int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return new int[] {-1, -1};
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<= nums.length; i++) {
			int res = target-nums[i];
			
			if(map.containsKey(res))
				return new int[] {map.get(res), i};
			
			map.put(nums[i], i);
		}
		// brute for approach [ O(n^2) ]
		/*for(int i=0; i<= nums.length; i++) {
			for(int j=i+1; j<=nums.length; j++) {
				if(nums[i] + nums[j] == target)
					return new int[] {i, j};
			}
		}*/
		
		return new int[] {-1, -1};
	}

	public static void main(String[] args) {
		int[] nums= {2, 7, 11, 15};
		int target = 9;
		int[] res = twoSum(nums, target);
		System.out.print(Arrays.toString(res));
	}

}