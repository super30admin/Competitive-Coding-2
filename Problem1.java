// Time Complexity: O(n)
// Space Complexity: O(n)

// 1 pass approach to store in hashmap and find complement exists in array 

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        // in n pass, store indices in hashmap
        for (int i=0; i<nums.length; i++) {
            int complement = target - nums[i];

            if (indexMap.containsKey(complement)) return new int[] {i, indexMap.get(complement)};

            indexMap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
