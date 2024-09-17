import java.util.HashMap;

// Time Complexity : O(N) , 
// Space Complexity : O(N)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no
public class problem1 {
class Solution {
	public int[] twoSum(int[] nums, int target) {
	HashMap<Integer,Integer> h = new HashMap<>();
    for(int i =0;i<nums.length;i++){
	            h.put(nums[i],i);
	        }
     for(int i =0;i<nums.length;i++){
     int complement = target - nums[i]; 
	 if(h.containsKey(complement)  && h.get(complement) != i){
	 return new int[] {i,h.get(complement)};
	            }
	        }

	        return new int[] {-1,-1};
	    }
	} 
}