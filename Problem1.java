class Solution {
    //Time O(N)
    //Space O(N)
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        {
            return new int[] {};
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                return new int[] {i,map.get(target-nums[i])};
            }
            map.put(nums[i] , i);
        }
        return new int[] {-1,-1};
    }
}