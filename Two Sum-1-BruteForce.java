class Solution {
    // Brute Force Approach
    // O(n^2) where n is number of elements in nums array
    public int[] twoSum(int[] nums, int target) {

        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
        
    }
}
