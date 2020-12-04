class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int s=0; s<nums.length; s++)
        {
            map.put(nums[s], s);
        }
        for(int i=0; i<nums.length; i++)
        {
            int extra_num = target - nums[i];
            if(map.containsKey(extra_num) && map.get(extra_num)!=i)
            {
                return new int [] {i, map.get(extra_num)};
            }
        }
        return new int[] {-1,-1};
    }
}