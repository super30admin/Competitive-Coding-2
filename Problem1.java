// Problem 1 - https://leetcode.com/problems/two-sum/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Competitive_Coding_2

package S30_Codes.Competitive_Coding_2;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]), i};
            }
            else
                map.put(nums[i], i);
        }

        return new int[2];
    }
}
