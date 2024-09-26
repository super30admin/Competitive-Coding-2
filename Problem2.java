// Two Sum Problem

// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

import java.util.HashMap;
class Problem2{
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++){
            int c = target-nums[i];
            if(map.containsKey(c) && map.get(c) !=i){
                return new int[]{map.get(c), i} ;
            }
        }

        return new int[] {-1,-1};
    }
}