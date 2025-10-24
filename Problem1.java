//Time Complexity: O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int difference = target-nums[i];
            if(map.containsKey(difference)){
                return new int[]{i,map.get(difference)};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}