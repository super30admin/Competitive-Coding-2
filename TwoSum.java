/*
 * #1. Two Sum
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

1. 2 <= nums.length <= 105
2. -109 <= nums[i] <= 109
3. -109 <= target <= 109
4. Only one valid answer exists.

 */


/*
 * Time Complexity using optimal approach: O (N) -> To traverse the elements of input array
 * 
 * Space Complexity using optimal approach: O (N) -> Created HashMap to store 'n' elements in an array
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.competitivecoding2;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
	    
		// Base condition
		if(nums == null || nums.length == 0 || nums.length == 1){
			return new int[0];
	    }
	        
	    int[] output = new int[2]; // Create an 'int' array to store output
	    HashMap<Integer, Integer> map = new HashMap<>(); // Create HashMap to store elements in array as key and its indices as value
	   
	   /************* 1. Brute Force Approach ********************/
	    
	    /*
	     * Approach 1: Brute Force
				- Use two pointers 'i' and 'j' 
				- For each element in the array (i pointer), traverse through rest of the elements (j pointer) 
				- And, check if sum of both ith and jth element is equal to target
				- If yes, then get the indices of two numbers. store it in array
				- Return the array
	     */
	    
	    /*
	     * Time Complexity: O (N^2)
	     * Space Complexity: O (1)
	     */
	    
	    /***************** Code **************************/
	    for(int i = 0; i < nums.length-1; i++){
	    	for(int j = i+1; j < nums.length; j++){
	    		if((nums[i] + nums[j]) == target){
	    			output[0] = i;
	    			output[1] = j;
	    			break;
	            }
	        }
	    }
	    
	    /***************** 2. Two Pass Hash Table ******************/
	    
	    /*
	     * Approach 2: Two Pass Hash Table (HashMap)
				- First, traverse through  the input array and fill the key value pairs in a HashMap
				- key -> element in an array, value -> index of the element
				- Traverse through the input array again
					- Find the complement of a element (target - nums[i])
					- Check if that complement presents in a key of a HashMap and index of complement not equal to current element in an array (since we cannot use same element twice to get sum = target)
					- If yes, then get the indices of both element from array and complement from HashMap key, store it in output array
					- And exit from the for loop
				- Return the output array with indices
	     */
	    
	    /*
	     * Time Complexity: O (N)
	     * Space Complexity: O (N)
	     */
        
	    /*********************** Code **************************/
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                output[0] = i;
                output[1] = map.get(complement);
                break;
            }
                
        }
	    
	    /**************** 3. One Pass Hash Table ********************/
	    
	    /*
	     * Approach 3: One Pass Hash Table
					- Using just one for loop
					- While we iterate and inserting elements into the table,
	      			  we also look back to check if current element's complement already exists in the table. 
	      			  If it exists, we have found a solution and return immediately. (exit from for loop)
	    			- Else, we put the 'element' as key and its 'index' as value in a HashMap	
	     */
	    
	    /*
	     * Time Complexity: O (N)
	     * Space Complexity: O (N)
	     */
	    
	    /**************** Code *********************/
	    for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                output[0] = i;
                output[1] = map.get(complement);
                break;
            }
            map.put(nums[i], i);
                
        }
	    
	    return output;       // Return the output array
	}
	    
}
