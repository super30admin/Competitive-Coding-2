// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes	
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer,Integer> hash = new HashMap<>();
     if(nums == null || nums.length == 0) return new int [] {-1,-1};
     for(int i = 0; i < nums.length; i++){
           hash.put(nums[i],i);
       } 
    for(int j = 0; j < nums.length; j++){
        int x = target - nums[j];
        if(hash.containsKey(x)){
            if(hash.get(x) != j){
                return new int [] {hash.get(x),j};
            }
        }
    }
        return new int [] {-1,-1};
    }
}