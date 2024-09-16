// Time Complexity : O(n) where n = length of nums array
// Space Complexity : O(n) where n = length of nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
public class Problem1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // If (target - current element) already exists in the hashmap, return [current index, hashmap[target - current element]]
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            // Else set hashmap[nums[i]] = current index
            map.put(nums[i], i);
        }
        // If no answer exists, return null
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }

}