// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0; i< nums.length; i++){
            int temp = target- nums[i];
            if(!map.containsKey(temp)){
                map.put(nums[i],i);
            }
            else{
                return new int[]{i,map.get(temp)};
            }
        }
        return new int[]{-1,-1};
    }
}