//Problem_1 : Two Sum
import java.util.HashMap;
import java.util.Map;
//TC : O(n)
//SC: O(n)
//Approach:-
/*
 * 1. Declare a hashmap to store the value and the index at which that value is present
 * 2. run a for loop from 0 to length of the array and find the complement 
 * 3. If the complement is present in the hashmap then return the index stored in the hashmap and the curret index
 * 4. else store the value and the index in the hashmap
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};// base case when array is empty

        Map<Integer, Integer> hm = new HashMap<>();//diff and the inddex

        for(int i=0; i<nums.length; i++){
            int sum = target - nums[i];

            if(hm.containsKey(sum)){
                return new int[]{hm.get(sum), i};
            }

            hm.put(nums[i], i);
        }

        return new int[]{-1,-1};//no such two indexes were found 
    }
}