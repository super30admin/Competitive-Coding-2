/*
    LC - 1. Two Sum
    TC - O(n)
    SC - O(n)
    Approach - Using HashMap, we can store the array value as key and its index in the value. check the difference and see if the value exists,
    if exists, return the index.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(myMap.containsKey(diff) && myMap.get(diff)!= i) {
                return new int[] {i, myMap.get(diff)};
            } else {
                myMap.put(nums[i], i);
            }
        }

        return new int[] {-1, -1};
    }
}