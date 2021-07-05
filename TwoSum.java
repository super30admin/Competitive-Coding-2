// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hMap = new HashMap<>(); //initialization of hashmap

        for(int i=0; i<nums.length; i++)
            if(hMap.containsKey(target-nums[i])) //HashMap keys are nums array and values are their corresponding indices
                return new int[] {hMap.get(target-nums[i]), i};
            else
                hMap.put(nums[i],i);
        return new int[] {};
    }
}