/**
 * 2 sum - 4 approaches: using all combinations(n^2), hashmap(n), 2 ptr(nlogn), binary search(nlogn)
 * Here, i have used hashmap - TC: O(n) SC: O(n) n: size of the input array
 */

class Solution{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

