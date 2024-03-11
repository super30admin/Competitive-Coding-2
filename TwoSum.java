class TwoSum {

    // TC-> O(N), where N is the length of nums
    // SC-> O(N), for HashMap
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};

        // Map of compliment and index
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            if(!map.containsKey(nums[i])){
                map.put(compliment, i);
            }else
                return new int[]{map.get(nums[i]), i};
        }
        return new int[]{-1,-1};
    }
}
