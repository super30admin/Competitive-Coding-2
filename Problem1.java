//Two Sum problem
// Time Complexity : O(n).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : As we have to check if the target can be achieved with addition of two numbers in the Array, I have calculated the difference by subtracting
// target and nums[i]. Then we check in the HashMap if the differnce is present, if not we add to the HashMap.


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};//return if already present in hashmap
            } else{
                map.put(nums[i], i);// add to hashmap
            }
        }
        return null;
    }
}