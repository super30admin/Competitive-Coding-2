class TwoSum {
    public int[] twoSum(int[] nums, int k) {
        if(nums==null || nums.length<2){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(k-nums[i])){
                return new int[] {map.get(k-nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
