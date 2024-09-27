
/* Time Complexity : O(N), where N is the length of nums array
   Space Complexity : O(N)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
   Method: Check if the value target-current number exists in map. If so, return the current index and the value. Else, add the current element as key and value as index.

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(target-nums[i]))
            {
                return new int[]{i, hm.get(target-nums[i])};
            }
            else
            {
                hm.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}