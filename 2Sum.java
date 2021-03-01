// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this approach , we are saving the different with the current number in a hashmap. 
// Whatever number we see from the input , we subtract it from the input and add that as key to hashmap and the index as value with that key.
// This way when iterating further in the input array , if the current number is already there as a key in the hashmap , that means we have seen the
// compliment for this before and we return the index from the key and current index. These two numbers are equal to the target.
// The compliment always is unique.,


class Solution {
    public int[] twoSum(int[] nums, int target) {
      
      HashMap<Integer,Integer> map = new HashMap<>();
      
      for(int i=0;i<nums.length;i++)       
      {
          if(map.containsKey(nums[i]))      
           {
             return new int[]{map.get(nums[i]),i};
           }
        else
        {
          map.put(target-nums[i],i);           
        }
      }
        return new int[]{-1,-1};
    }
}