//Time Complexity- O(n)
//Space Complexity=O(n)

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	int[] indicesofTarget(int[] nums, int target)
	{
		HashMap<Integer,Integer>map=new HashMap();
		for(int i=0;i<nums.length;i++)
		{
			int diff=target-nums[i];
			if(!map.containsKey(diff))
			{
				map.put(nums[i],i);
			}
			else{
				return new int[]{i,map.get(diff)};
			}
		}
		return new int[]{0,0};
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Solution solution=new Solution();
		int[]nums= new int[]{2,7,11,15};
		int[]indices=new int[2];
		indices=solution.indicesofTarget(nums,9);
		System.out.println("["+indices[0]+","+indices[1]+"]");
	}
}