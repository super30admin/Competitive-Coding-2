import java.util.HashMap;
import java.util.Map;

class TwoSum {
	//Time Complexity : O(n), where n is the length of nums
	//Space Complexity : O(n) for storing in the hashmap
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complement = new HashMap<>();
        int[] res = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            if(complement.containsKey(target - nums[i])) {
                res[0] = complement.get(target - nums[i]);
                res[1] = i;
            } else {
                complement.put(nums[i], i);
            }
        }
        
        return res;
    }
	
	//Time Complexity : O(n^2), where n is the length of nums
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        
        return res;
    }
}