using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(N) 
    // Space Complexity :O(N) 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class TwoSumArray
    {
        public int[] TwoSum(int[] nums, int target)
        {
            Dictionary<int, int> map = new Dictionary<int, int>();
            for (int i = 0; i < nums.Length; i++)
            {
                int complement = target - nums[i];
                if (map.ContainsKey(complement))
                {
                    return new int[] { map.GetValueOrDefault(complement), i };
                }
                if (!map.ContainsKey(nums[i]))
                {
                    map.Add(nums[i], i);
                }
            }
            return null;

        }
    }
}
