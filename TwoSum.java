// Time Complexity : O(N) //N is the length of array. actually 2 O(N) but constant neglected
// Space Complexity : O(N) //hashmap size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * 1. Store each number and its index in the hash map.
 * 2. Loop through the numbers and if target-number exist then current index and found index are answers .
 * 3. If not found return -1,-1.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> map=new HashMap<>();
		
		for (int i=0;i<nums.length;i++) {
			map.put(nums[i], i);
		}
		
		int index;
		for (int i=0;i<nums.length;i++) {
			index = map.getOrDefault(target-nums[i],-1);
			if(index >-1 && index!=i) {
				return new int[] {i,index};
			}
		}
		return new int[] {-1,-1};
	}
	
	public static void main(String[] args) {
		int[] nums= new int[] {2,7,11,15};
		System.out.println(Arrays.toString(new TwoSum().twoSum(nums, 9)));
	}

}
