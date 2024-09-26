// Time Complexity: O(n) where n = size of array
// Space Complexity: O(n) - extra space for map

// Approach
// Algorithm
// 1 - initiliaze map
// 2 - loop over elements
// 3 - get complement
// 4 - check if complement present then return
// 5 - else store in map
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 1
        Map<Integer, Integer> map = new HashMap<>();
        
        // 2
        for (int i=0; i<nums.length; i++) {
            // 3
            int diff = target - nums[i];
            // 4
            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            }
            // 5
            map.put(nums[i], i);
        }
        
        return null;
    }
}