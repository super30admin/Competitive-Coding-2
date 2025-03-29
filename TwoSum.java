class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for(int i=0 ;i<nums.length; i++){
            myMap.put(nums[i], i);
        }

        int [] res = new int[2];
        for(int i=0 ; i< nums.length; i++){
            int compliment = target - nums[i];
            if(myMap.keySet().contains(compliment) && i != myMap.get(compliment)){
                res[0] = i;
                res[1] = myMap.get(compliment);
            }
        }
    return res;
    }
}