package CompetitiveCodingDay2;

import java.util.*;

//Time Complexity : O(n) where n is the length of nums array
//Space Complexity : O(n) where n is the length of map
//Did this code successfully run on Leetcode : yes

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int difference = target - nums[i];
			if(map.containsKey(difference) && map.get(difference) != i) {
				return new int[] {i, map.get(difference)};
			}
		}
		return new int[] {-1, -1};
		
		// Brute force solution
		
//        int a[] = new int[2];
//        for(int i=0;i<nums.length-1;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                	a[0]=i;a[1]=j;return a;
//                }
//                
//            }
//        }
//        return a;
    }
	
	public static void main(String[] args){
        
		int[] nums = {2,7,11,15};
        System.out.println(twoSum(nums, 9));

    }
}
