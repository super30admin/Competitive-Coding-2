import java.util.HashMap;
import java.util.Map;
// Time Complexity : O(n) where n is the number of elements in the array
// Space Complexity : O(n) where n is the number of elements in the array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
// If we go by brute force approach, we can check for all the combinations of numbers to get the target,
//  but that will be O(n^2) time complexity.
// So we can use hashmap or hashset 
// Here we used hashmap to store the numbers and their indices,
//  and check for the complement of the current number in the hashmap,
//  if it exists, we return the indices of the current number and the complement.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashnum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];

            if (hashnum.containsKey(num)) {
                return new int[] { hashnum.get(num), i };
            } else {
                if (!hashnum.containsKey(nums[i])) {
                    hashnum.put(nums[i], i);
                }
            }
        }
        return null;
    }
}