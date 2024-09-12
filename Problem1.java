class Solution {
    //Time - O(n)
    //Space - O(n)
    public int[] twoSum(int[] nums, int target) {
        // populate hashmap
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && i != map.get(diff)) {
                return new int[] { map.get(diff), i };
            }
        }
        return new int[2];
    }
}
