// Time complexity:- O(n)
// Space complexity:- O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach:
 * This problem is about finding two indices in the array such that the numbers at those indices add up to the target value. 
 * I used a HashMap to store each number and its index, which allows me to efficiently look for a number that, 
 * when added to the current number, equals the target. In the second loop, I checked if such a number exists in 
 * the map and ensured that the indices are not the same before returning the result. 
 */ 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Initialize an array to hold the result with two indices.
        int[] result = new int[2];

        // Create a HashMap to store the numbers as keys and their indices as values.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store each number and its index in the HashMap.
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //Check if the complement (target - nums[i]) exists in the map.
        for(int i = 0; i < nums.length; i++) {
            // Find the difference between target and nums[i].
            int num = target - nums[i];
            // If the difference exists in the map, check if it's not the same element .
            if(map.containsKey(num)) {
                // Ensure that the complement isn't the current number itself by comparing indices.
                if(map.get(num) != i) {
                    // Store the two indices that make up the target sum
                    result[0] = i;
                    result[1] = map.get(num);
                }
            }
        }
        // Return the indices of the two numbers that add up to the target.
       return result;      
    }
}