// Time Complexity :  O(N) 
// Space Complexity : O(N) - Max elements being stored at hashmap
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //one pass hash map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                return new int[] {i, map.get(comp)};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1,-1};
    }
}