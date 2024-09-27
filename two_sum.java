class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i <= nums.length - 1; i++){
            int com = target - nums[i];
            if(map.containsKey(com)){
                return new int[] {i, map.get(com)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
