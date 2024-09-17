// Problem Statement : an array is given in the question and you need to return the indices of
 // two numbers such that they add up to a specific target. 
 // assume that there is only one solution for each input and you cannot use the same element twice.

 // Time Complexity - O(n) 
 // Space Complexity - O(n) to store elements in hashtable
 // Successfully ran on leetcode
 // No problems while solving problem

 // Approach :  While we iterate and inserting elements into the table, we also look back to check 
//  if current element's complement already exists in the table. 
//  If it exists, we have found a solution and return immediately.
 import java.util.HashMap;
 class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int []{i, map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return arr;
    }
}