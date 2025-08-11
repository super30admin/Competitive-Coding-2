// Time Complexity : O(n) — We traverse the array once and each HashMap operation (put/get) takes O(1) average time.
// Space Complexity : O(n) — We store at most n elements in the HashMap.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Your code here along with comments explaining your approach :
// We use a HashMap to store each number and its index as we iterate through the array.
// For each number, we calculate its complement (target - current number).
// If the complement already exists in the map, we have found the two indices that sum up to the target.
// Otherwise, we store the current number and its index in the map for future lookups.

import java.util.*;

public class Problem2 {
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int com = target - nums[i]; // complement needed to reach target
            if(map.containsKey(com)){
                return new int[] {map.get(com), i}; // found the pair
            }
            map.put(nums[i], i); // store current number and index
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target))); // expected : [0,1]
    }
}