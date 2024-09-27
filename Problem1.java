// Two Sum
// Time Complexity - O(N)
// Space Complexity - O(N) // No auxilary space used

import java.io.*;
import java.util.*;

class Solution {
	
	public static int[] hashMap(int[] arr, int target)
	{
	    // DS 
	    HashMap<Integer, Integer> map = new HashMap<>();
	    
	    // base
	    if(arr==null) return new int[] {-1,-1};
	    
	    for(int i=0; i<arr.length;i++)
	    {
	        if(map.containsKey(target-arr[i]))
	        {
	            return new int[] {i,map.get(target-arr[i])};
	        }
	        
	        map.put(arr[i],i);
	    }
	    
	    throw new IllegalArgumentException("Not available");
	} 
	
	public static void main (String[] args) {
		int arr[] = {2,7,11,15};
		int target = 9;
		int result[] = hashMap(arr, target);
		System.out.println(result[0]+" "+ result[1]);
	}
}