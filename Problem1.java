//Time Complexity - O(n) - we iterate over all n elements 
//Space complexity - O(n)
//Did it run in leetcode - Yes

//Approach
/*
Use HashMap to store each element and its corresponding index.
Calculate the complement while iterating over the elements with the target given
Return the indices if the complement matches the element present in map
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}
