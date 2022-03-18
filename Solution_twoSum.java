/*

Time Complexity  : O(n) where n is the length of the array.
Space Complexity :  O(n) where n is the size of the Hashmap.
Leetcode :  yes worked on the leetcode.

Approch :  Started iterating through the nums array and checking if the target - value 
of number is present in the map then returning that otherwise putting value of number inside the hashmap.

*/
import java.util.*;

class Solution_twoSum {
    public int[] twoSum(int[] nums, int target) {
        // null case
        if(nums.length == 0 || nums == null) {
            
            return new int[]{};
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i =0; i<nums.length;i++) {
            
            int element =  target - nums[i];
            
            if(map.containsKey(element)) {
                
                return new int[] {i,map.get(element)};
            }
            else {
                
                map.put(nums[i],i);
            }
            
        }
        return new int[]{};
    }
}