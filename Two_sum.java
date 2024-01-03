// Time Complexity : O(n) 
// Space Complexity : 0(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i< nums.length; i++)
        {
            int diff = target - nums[i];
            if(hmap.containsKey(diff))
            {
                return new int []{hmap.get(diff),i};
            }
            hmap.put(nums[i],i);
        }
        return new int[]{-1,-1};
        
    }
}