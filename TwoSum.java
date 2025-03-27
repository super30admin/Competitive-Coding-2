
//Time Complexity : O(N) -> N is the number of elements in the array
//Space Complexity : O(N) -> N is the number of elements in the array

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int i = 0; i < nums.length ; i++) {
            int complement = target - nums[i] ;
            if(hmap.containsKey(complement)) {
                return new int[]{i,hmap.get(complement)};
            }
            hmap.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
