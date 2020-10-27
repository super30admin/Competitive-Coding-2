// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 1


class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0 ; i <= nums.length; i++)
        {
            int c = target - nums[i];
            if(map.containsKey(c))
            {
                return new int[] {i, map.get(c)};
            }
            map.put(nums[i],i);
        }
   throw new IllegalArgumentException("No two sum solution");
    }
   
}