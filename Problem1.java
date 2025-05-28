/* Question: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 * 
 * Approach -
 * Brute - Force Solution: we use nested loops where first loops goes from 0 to n where n = length of array
 * and second loop goes from i+1 to n, if nums[i] + nums[j] == target return [i,j]
 * Time and Space Complexity: Time - O(n^2) Space - O(1)
 * Optimized Solution: 
 */

import java.util.Arrays;
import java.util.HashMap;

public class Problem1 {
    static int[] twoSum(int[] nums, int target) {
        int[] res = { -1, -1 };
        HashMap<Integer, Integer> complimentMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (complimentMap.containsKey(nums[i])) {
                int zero = i;
                int one = complimentMap.get(nums[i]);
                res[0] = zero;
                res[1] = one;
            } else {
                int compliment = target - nums[i];
                complimentMap.put(compliment, i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums_1 = { 2, 7, 11, 5 };
        int target_1 = 9;
        System.out.println(Arrays.toString(twoSum(nums_1, target_1)));
        int[] nums_2 = { 3, 2, 4 };
        int target_2 = 6;
        System.out.println(Arrays.toString(twoSum(nums_2, target_2)));

    }

}