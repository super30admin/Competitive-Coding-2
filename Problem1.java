// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // intialize the array to be returned
        int[] result = new int[2];
        // return empty array if input array is null or empty
        if(nums == null || nums.length == 0) return result;
        // intialize hashmap and store every element of array
        // along with its index
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        // iterate through array and find the complement
        // if the complement is found in hashmap,
        // return the indexes in an array
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            }
        }
        return result;
    }
}