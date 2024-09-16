// Time complexity: O(n)
// Space complexity: O(n)

import java.util.*;
public class Problem29_TwoSum {
    public static void main(String[] args) {
        // int[] nums = {2, 7, 11, 15};
        int[] nums = {3, 3, 9, 15};
        int[] result = new int[2];
        result = twoSum(nums, 6);
        System.out.println(result[0] +","+ result[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        if(nums.length == 0 || nums == null)
            return new int[] {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]))
                return new int[] {i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}