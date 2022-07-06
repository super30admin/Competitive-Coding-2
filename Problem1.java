//Time Complexity: O(n)
//Space Complexity: O(n) 
// Code run successfully on LeetCode.

import java.util.HashMap;

public class Solution{
	
	public int[] twoSum(int[] nums, int target) {
		
		if(nums == null|| nums.length == 0)
			return new int[] {};
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int diff = 0;
		int a =0, b= 0;
		
		for(int i =0; i < nums.length; i++) {
			
			diff = target - nums[i];
			if(map.containsKey(diff)) {
				 a = map.get(diff);
				 b = i;
				 return new int[] {a,b};
			}
			
			else
				map.put(nums[i], i);
		}
		return new int[] {};
    }
}