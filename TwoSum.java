// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//We will use hashmap to store the key and index of the element as value and calculate its difference

import java.util.HashMap;

class TwoSum{
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
          
          // Iterate through the array
          for (int i = 0; i < nums.length; i++) {
              // Calculate the difference
              int difference = target - nums[i];
              
              // If the difference is in the map, return the result
              if (numMap.containsKey(difference)) {
                  return new int[] { numMap.get(difference), i };
              }
              
              // Otherwise, add the current number and its index to the map
              numMap.put(nums[i], i);
          }
          
          // Since the problem guarantees exactly one solution, this line will never be reached
          return new int[] {};  
      }
}