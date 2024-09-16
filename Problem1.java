/*
TC : O(n) where n is the length of the input array
 SC :O(n) for the hashmap
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
 */

/**
 * Here we use use the approach of creating a hashmap and storing the element and its index as Key-Value pair
 * The element k will be one of elements of solution only if target - k element is also present. This is the theme used.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(target-nums[i])) {
                map.put(nums[i],i);
            } else {
                return new int[] {i, map.get(target-nums[i])};
            }
        }
        return new int[]{};
    }
}