package S30.CompetitiveCoding_2;

/*
Time Complexity : Put: O(n),
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.HashMap;

public class Problem1 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }
}
