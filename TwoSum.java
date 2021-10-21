// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
       int[] result=new int[2];
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(target-nums[i])) {
				result[0]=map.get(target-nums[i]);
				result[1]=i;
				return result;
			}
			
			map.put(nums[i], i);
		}
		
		return result;
    }
}