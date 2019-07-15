class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int secondNumber = target - nums[i];
            if(hm.containsKey(secondNumber)){
                return new int[]{i,hm.get(secondNumber)};
            }
            hm.put(nums[i], i);
        }
        return new int[] {-1, -1};   
    }
}