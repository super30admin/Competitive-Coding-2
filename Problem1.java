//Use a HashMap to store each number’s value -> index as you scan.
// For each nums[i], compute complement = target - nums[i]; if it’s already in the map, return the stored index and i.
// O(n) time with O(n) extra space.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int cmp = target - nums[i];
            if (map.containsKey(cmp)) {
                return new int[]{map.get(cmp),i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
