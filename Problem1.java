// Two Sum-1

// brute force
// TC - O(n^2)
// SC - O(1)


class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}

//optimized
// TC - O(1)
// SC - O(n) 

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map <Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i ++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i ++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        return new int[] {-1,-1};
    }
}