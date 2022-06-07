// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i){
                return new int[]{i, map.get(target-nums[i])};
            }
        }

        return null;
    }

    public static void main(String [] args){
        int [] nums = new int[]{2,7,11,15};
        TwoSum ts = new TwoSum();
        System.out.println(Arrays.toString(ts.twoSum(nums, 18)));
    }
}