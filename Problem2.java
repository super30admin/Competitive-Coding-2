/*
Hi Rutuja

Welcome to FAANMG Problem of the Day

Problem Name: Interview Problem : Two elements sum to target

Source Link: https://leetcode.com/problems/two-sum/

Submit your solution in Github here

Thanks

Team S30
 */

/*
time : O(n)
Space : O(n)
Approach : Use Hashmap to store indices
 */
import java.util.*;

class Problem2 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[] { i, map.get(target - nums[i]) };
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] output = twoSum(nums, target);
        System.out.println("Answer is : "+ output[0] + "  " + output[1]);
    }
}

