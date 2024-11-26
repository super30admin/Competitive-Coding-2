class Problem1 {

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement))
                return new int[]{i, map.get(complement)};
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}