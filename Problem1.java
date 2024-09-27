import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(n) where n is length of array.
// Space Complexity : O(n)
class Problem1 {
    public int[] twoSum(int[] nums, int target) {   
    	if(nums==null || nums.length==0) return new int[] {-1,-1};
    	
        //Map of elements with index
        Map<Integer, Integer> map= new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int temp= target-nums[i];
            //If sum found
            if(map.containsKey(temp)){
                return new int[]{i, map.get(temp)};
            }else{
                map.put(nums[i], i);
            }
        }
        
        return new int[]{-1,-1};
    }
}