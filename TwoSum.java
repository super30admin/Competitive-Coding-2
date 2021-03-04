import java.util.*;

public class TwoSum {
	
	//TC- o(n)
    //SC - o(n)
    public int[] twoSum(int[] nums, int target) {
        
        if(nums == null || nums.length == 0)
            return new int [] {-1,-1};
        
        //searching of elements in o(1)
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            //check comp is present in the map or not
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                //if present return indices 
                return new int [] {map.get(comp),i};
            }
            //else add nums[i] to map for next iteration
            map.put(nums[i],i);
        }
        return new int [] {-1,-1};
    }

}
