class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        if(nums ==  null || nums.length == 0 |nums.length ==1){
            return new int[] {-1,-1};
        }
        //Data structures
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i ,map.get(target-nums[i])};

            }
            else{
                map.put(nums[i] , i);
            }
        }
        return new int[] {-1, -1};
    }
}