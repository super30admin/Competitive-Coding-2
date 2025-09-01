class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (indices.containsKey(comp) && i != indices.get(comp)) {
                return new int[] {i, indices.get(comp)};
            }
        }

        return new int[] {-1,-1};
    }
}