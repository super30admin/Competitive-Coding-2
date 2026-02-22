class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> valueDiffMap = new HashMap<>();

        for(int i = 0; i < nums.length;i++) {
            int diff = target - nums[i];

            if(valueDiffMap.containsKey(diff)) {
                return new int[]{valueDiffMap.get(diff), i};
            } else {
                valueDiffMap.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}