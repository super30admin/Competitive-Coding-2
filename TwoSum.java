
//T(C) : O(n)
//S(C) : O(n)
//it ran on leetcode: yes
public class TwoSum {

	 public int[] twoSum(int[] nums, int target) {
	        int[] output = new int[2];
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        for(int i =0 ; i<nums.length;i++){
	            int z = target - nums[i];
	            if(map.containsKey(z)){         
	            output[0] = i;
	            output[1] = map.get(z);
	                
	            return output;    
	            } else
	                
	             map.put(nums[i],i);            
	        }
	        return output;
	        }
	
}
