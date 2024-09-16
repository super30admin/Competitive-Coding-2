/*
LC No: 1 - https://leetcode.com/problems/two-sum/
TC: O(n) - as the numbers that make up the sum could be at the end of the array
SC: O(n) - worst case we might end up storing (n-1) entries in the HashMap, if the numbers are at the end

Approach - Store for every number, the remaining sum needed to make up the target,
and the index where the number was found.
HashMap entries - <Remaining_sum, index>
*/

import java.util.HashMap;

public class Problem1 {
    public static int[] twoSum(int[] nums, int target) {
        int res[] = new int[] {-1, -1};
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0]= map.get(target - nums[i]);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        
        return res;
    }

    public static void printArray(int a[]) {
        for (int num: a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        printArray(twoSum(new int[] {2, 7, 11, 15}, 9));    // 0 1
        printArray(twoSum(new int[] {3, 2, 4}, 6));         // 1 2
        printArray(twoSum(new int[] {3, 3}, 6));            // 0 1
        printArray(twoSum(new int[] {2, 2, 3, 1}, 4));      // 2 3
    }
}