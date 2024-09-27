class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            if(map.containsKey(compliment)){
                res[0] = i;
                res[1] = map.get(compliment);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}