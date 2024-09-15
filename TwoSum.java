import java.util.HashMap;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans={-1,-1};
        //use haspmap to store the number and the index
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<nums.length; i++){
            //if the map contains the difference, then we found a pair
            //and we return the index of it
           if(map.containsKey(target-nums[i])){
           int another=map.get(target-nums[i]);
            ans[0]=another;
               ans[1]=i;
            }
            else{
                //add the number which does not exist in map
            map.put(nums[i],i);
            }
            
        }return ans;
        } 
    }
