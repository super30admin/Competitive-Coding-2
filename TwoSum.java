// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class TwoSum
{
    class Solution
    {
        public int[] twoSum(int[] nums, int target)
        {
            HashMap<Integer, Integer> map = new HashMap();
            map.put(nums[0], 0);

            for(int i = 1; i < nums.length; i++)
            {
                int key = target - nums[i];

                if(map.containsKey(key))
                    return new int[]{ map.get(key), i};
                else
                    map.put(nums[i], i);
            }
            return null;
        }
    }
}
