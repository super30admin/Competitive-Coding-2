class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!(hmap.containsKey(target - nums[i]))){
                hmap.put(nums[i],i);
            }
            else{
                return new int[]{i,hmap.get(target-nums[i])};
            }

        }
        return null;
    }
}