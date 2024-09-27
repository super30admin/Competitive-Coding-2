//Time O(n)
//leetcode tested

lass TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hMap.put(nums[i], i);
        }
        int complement = 0;
        int pos1 = 0;
        int pos2 = 0;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (hMap.containsKey(complement)) {
                pos1 = i;
                pos2 = hMap.get(complement);
                if (pos1 != pos2)
                    return new int[]{pos1, pos2};
            }

        }
        return new int[]{};
    }
}
