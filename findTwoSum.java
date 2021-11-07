// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(hashMap.containsKey(target-nums[i])) {
                return new int[] {i, hashMap.get(target-nums[i])};
            }
            else {
                hashMap.put(nums[i],i);
            }
        }
        return new int[] {-1,-1};
    }
}

