// Time Complexity : O(n), where n is the number of elements in the array
// Space Complexity : O(n), for storing elements and their indices in the HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This is a single-pass HashMap solution. As we iterate through the array,
// we compute the complement (target - current element). If the complement
// exists in the map, we've found the two numbers that sum to the target.
// Otherwise, we add the current number and its index to the map for future reference.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map =  new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Check if the complement already exists in the map
            if(map.containsKey(target - nums[i])){
                // Return indices of the complement and current element
                return new int[]{map.get(target - nums[i]),i};
            }
            // Otherwise, add current element and its index to the map
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}