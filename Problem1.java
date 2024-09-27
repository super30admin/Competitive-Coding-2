class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
            {
                int comple = target - nums[i];
                if(map.containsKey(comple))
                {
                    result[0] = map.get(comple);
                    result[1] = i;
                    break;
                    
                }
                map.put(nums[i], i);
            }
        return result;
        
    }
}
//tc=O(n)
//sc=O(n)
