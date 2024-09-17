//Problem : 29 - Two Sum
//TC : O(n), n means size of array
//SC : O(n)

/**
 Steps:  
 Create a map for storing element as key and index as value. Then, Just find the compliment of target and the arr[i], if compliment exists in the map, just return the index of that compliment and the current index. 
  On each iteration add element and the index in the map.
*/
import java.util.*;
class Solution29 {
    public int[] twoSum(int[] nums, int target) {
       
        //TC:O(n), SC:O(n)
        int[] res = new int[2];
        
        if(nums==null || nums.length==0){
          return res;   
       } 
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int compliment = target-nums[i];
            
            if(map.containsKey(compliment)){
                res[0] = map.get(compliment);
                res[1] = i;
                    
                return res;
            }
            
            map.put(nums[i],i);
        }
        
        return res;
    }
}