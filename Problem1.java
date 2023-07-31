// Time Complexity : O(n), n is the number of items in the array.
// Space Complexity : O(n), n is the number of items in the map.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Use a hashmap to store the complements of the each value in array with the target.
 * 2. If the complement is present in the map, then return the index of the complement and the current index.
 * 3. If the complement is not present in the map, then add the value and the index to the map.
 * 4. If no such pair is found, then return -1, -1.
 */


import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for(int i=0; i<len; i++){
            int key = target - nums[i];
            if(map.containsKey(key)){
                return new int[]{map.get(key), i};
            }else{
                map.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}