// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on GFG : Yes
// Any problem you faced while coding this : No

// Approach: I use a hashmap to store the index of each number as I iterate through the array. For each number, I check if the complement (target - current number) exists in the map. If it does, I return the indices of both numbers.

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int [] ans = new int [2];
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                ans[0] = map.get(target-nums[i]);
                ans[1]=i;
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}