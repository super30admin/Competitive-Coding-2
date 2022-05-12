/**
Time Complexity : O(N) N = input size
Space Complexity : O(N) N = input size
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution 
{
    public int[] twoSum(int[] nums, int target) 
	{
        int result[] = new int[]{-1,-1};

		if( nums == null || nums.length == 0)
			return result;

		Map<Integer, Integer> map = new HashMap<>();

		for(int i =0; i< nums.length; i++)
		{
			int diff = target - nums[i];

			if(map.containsKey(diff))
			{
				result[0] = map.get(diff);
				result[1] = i;
				
				return result;
			}

			map.put(nums[i], i);

		}


		return result;
    }
}