// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++)
        {
            int b = target - nums[i];
            if(map.containsKey(b) && map.get(b) != i)
            {
                return new int[]{i, map.get(b)};
            }
        }
        return new int[]{-1, -1};
    }
}