import java.io.*;
Time Complexitiy: O(n)
Space Complexitiy: O(1)

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

class Solution
{

	 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
   static  Integer[] minimumDistance(int nums[], int target)
    {
      HashMap <Integer,Integer> map = new HashMap();
     // ArrayList<Integer[]> list = new ArrayList();
      int difference = 0;
      
      for(int i =0; i<nums.length;i++)
      {
    	  difference = target - nums[i];
    	  if(map.containsKey(difference))
    	  {
    		  Integer index = map.get(difference);
    		  //list.add( new Integer[]{i,index});
    		  return new Integer[] {index,i};
    	  }
    	  else
    		  map.put(nums[i],i);
      }
      
      
      return new Integer[] {-1,-1};
     // return list.add( new Integer[]{i,index});
    }
	
	public static void main(String args[])
	{
		
		int [] nums = {2, 7, 5,4};
		int target = 9;
		System.out.println(minimumDistance(nums,target)[1]+"Hi"+minimumDistance(nums,target)[0]);
	}
	
}
