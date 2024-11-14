//https://leetcode.com/problems/two-sum/

import java.util.HashMap;

class Problem1 {

    public int[] twoSum(int[] nums, int target) {
        //  int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            int comp= target - nums[i];
            if (map.containsKey(comp))
            {
                return new int[]{map.get(comp), i};
            }
            else {
                map.put(nums[i],i);
            }
        }

        throw new IllegalArgumentException("record not found");

    }
}