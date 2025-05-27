/*
  Time complexity: O(n)
  Space complexity:O(1)

  Code ran successfully on leetcode: Yes

*/

public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        
        Dictionary<int,int> dict = new Dictionary<int,int>();
        
        for(int i=0;i<nums.Length;i++)
        {
            if(dict.ContainsKey(target-nums[i]))
                return new int[2]{i, dict[target-nums[i]]};
            else
                if(!dict.ContainsKey(nums[i]))
                    dict.Add(nums[i],i);
                else
                    dict[nums[i]] = i;
        }
        
        return new int[2];
    }
}
