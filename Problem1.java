class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){   //Storing the key value pair in hashmap
            map.put(nums[i], i );
        }
        for(int i = 0; i < nums.length; i++){
            int CurrentNum = nums[i];
            int Remainder = target - nums[i];
            if(map.containsKey(Remainder)&& i != map.get(Remainder)){
                return new int [] {i, map.get(Remainder)};
            }
        }
        return new int[]{};
    }
}