class Solution {
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We use a HashMap to store numbers and their indices while iterating.
For each number, we compute its complement (target - nums[i]).
If the complement exists in the map, we return its index and the current index.
Otherwise, we store the current number and continue.
This ensures an O(n) time complexity with constant-time lookups.
*/

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int comp=target - nums[i];
            if(map.containsKey(comp))
            {
                return new int[]{map.get(comp),i};
            }
            else
            {
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}