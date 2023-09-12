class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Brute Force Approach 
        // Time Complexity: O(n^2) where n is number of elements in the array.

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++)
        {
            int complement = target-nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i)
            {
                return new int[]{i, map.get(complement)}; 
            }
        }

        return new int[]{-1,-1};
        
    }
}
