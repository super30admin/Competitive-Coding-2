// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english:
//For each value in the array, we subtract it with the target.
//The resulting value should be in the hashmap already for there to be a pair that equals to the target value.

// Your code here along with comments explaining your approach
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //base case to check if the array is empty
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        for(int i = 0; i < nums.length; i++){
            
            //we take the compliment and check if it exists in the map already
            int subtracted = target - nums[i];
            
            //if it does exist already then we found a pair
            if(map.containsKey(subtracted)){
                return new int[]{map.get(subtracted), i};
            }
    
            map.put(nums[i], i);
    
        }
        return new int[]{-1, -1};
    }
}