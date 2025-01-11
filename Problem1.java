// Problem 1: Two Sum
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

import java.util.HashMap;
import java.util.Arrays;
public class Problem1 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 ){
         return new int[]{};
        } 
        HashMap<Integer,Integer> set = new HashMap<>();
 
        for (int i =0; i< nums.length;i++){
             set.put(nums[i],i);
          
        }
        for (int i = 0;i < nums.length;i++){
         if (set.containsKey(target-nums[i])){
             if(i != set.get(target-nums[i]))
             return new int[]{i, set.get(target-nums[i])};
         }
        }
 
 return new int[]{0};
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // expected output: [0, 1]
    }
}
