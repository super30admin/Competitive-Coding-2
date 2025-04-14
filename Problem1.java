// Two Sum
/* Description: I am storing target-nums[i] in hashmap for each element. Then looking for nums[i] in hashmap, 
if found, returning the array with 2 indices
 */
// Time Complexity : O(n) - Going through each element in nums array
// Space Complexity : O(n) - Hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
// Using two hashmaps:
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Initializing hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        // Storing the remval as key in hashmap, so initializing it
        int remVal = 0;
        // Result array
        int[] result = new int[2];
        // Looping through all element in nums
        for (int i = 0; i < nums.length; i++) {
            // For each calculating, remVal=target - nums[i]
            remVal = target - nums[i];
            // Then looking for nums[i] in map
            if (map.containsKey(nums[i])) {
                // found then updating the result array
                result[0] = map.get(nums[i]);
                result[1] = i;
            } else {
                // else adding the entry (remVal, index) into the map
                map.put(remVal, i);
            }
        }
        // Returning result array
        return result;
    }
}