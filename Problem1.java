// Time Complexity :O(n) n is the length of the array
// Space Complexity : O(n) n is the length of the array
// Did this code successfully run on Leetcode :Yes

// Your code here along with comments explaining your approach


import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i =0;i<nums.length;i++){
            int result = target - nums[i];
            if(map.containsKey(result)){
                return new int[]{i,map.get(result)};
            }
            else
            {
                map.put(nums[i],i);
            }
        }
        
        return new int[]{-1,-1};
    }
}