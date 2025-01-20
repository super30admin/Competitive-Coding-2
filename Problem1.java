import java.util.HashMap;
import java.util.Map;

//Time Complexity: O(n)
//Space Complexity O(n)
//Yes the code ran successfully in leetcode
//No problem faced
//1. Two Sum


class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>(); // map stores key value pair

        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (numMap.containsKey(diff)) { // check if the complement number is present as key
                return new int[] { numMap.get(diff), i }; // returns both indices
            } else {
                numMap.put(nums[i], i); // add the number to the map along with index
            }
        }
        return null;

    }
 
 }
 