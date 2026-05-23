class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int cmp = target - nums[i];
            if (map.containsKey(cmp) && map.get(cmp) != i) {
                return new int[]{map.get(cmp),i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
