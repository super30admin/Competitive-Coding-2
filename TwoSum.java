package s30Coding;
import java.util.*;

//Time Complexity :- 0(n)

//Space Complexity :- O(n)

//Leet Code :- Yes

// Logic :- The idea is to take the difference of current element and the target and check if it is present in the map,
//			if yes return index of the current element and the difference element, else add the current element
//			to the hashmap

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            else{
                map.put(nums[i], i);
            }
        }
        
        return new int[]{}; 
    }
}
