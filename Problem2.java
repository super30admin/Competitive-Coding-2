// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[0];
    }

    public static void main(String args[]) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum(nums, target);

        for(int i : ans){
            System.out.println(i);
        }
    }
}
