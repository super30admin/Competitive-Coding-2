import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // First pass: store elements and their indices
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);  
        }

        // Second pass: find the complement
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Fix: Use get() instead of direct indexing (map[complement] → map.get(complement))
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)}; // Fix: Correct array syntax
            }
        }

        return new int[] {-1, -1}; // Fix: Correct array syntax
    }
}
