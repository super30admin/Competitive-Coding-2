//Two sum
//an array is given in the question and you need to return the indices of two numbers such that they add up to a specific target. assume that there is only one solution for each input and you cannot use the same element twice. 

//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

/* Brute Force solution
Store the value and index in a HashMap and check if the compliment is present. 
If it is present, the compliment and value makes up the target so return the index of value and compliment (from hashmap)
*/
// Your code here along with comments explaining your approach


class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> map= new HashMap<>(); // to store value and index
        
        for(int i=0;i<nums.length;i++) // traversing through the array
        {
            int compliment = target - nums[i]; // finding compliment of the value 
            
            if(!map.containsKey(compliment)) // check if map contains compliment
            {
                map.put(nums[i],i); // put the value and index
            }
            else
            {
                return new int[] {i, map.get(compliment)}; // return index of value and get the compliment's index 
            }
        }
        return new int[]{-1,-1}; // else new array of {-1,-1} values
    }
}





