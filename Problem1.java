/***************Sum of two elements equal to target**********/

// Time Complexity : 0(n) n=length of array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


//Intuition is to store all the seen index of elements in a hashmap and calculate the
//target - nums[index] at every index and get it from hashmap

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //base case
        if(nums.length==0|| nums==null){
            return new int[]{-1,-1};
        }

        HashMap<Integer,Integer> index=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer value=target-nums[i];
            if(index.containsKey(value)){
                return new int[]{index.get(value),i};
            }else{
                index.put(nums[i],i);
            }
        }

        return new int[]{-1,-1};
    }
}