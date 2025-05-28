two sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the value and its index


        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
