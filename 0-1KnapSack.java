// Time Complexity : O(n) thats length of nums
// Space Complexity : O(n) for the map
// Did this code successfully run on Leetcode : yes

class 0-1KnapSack{
    public boolean canPartition(int[] nums) {
            int sum = 0;

            for (int num : nums)
                sum += num;


            if ((sum & 1) == 1)
                return false;
            sum /= 2;

            int n = nums.length;
            boolean[] dp = new boolean[sum+1];
            Arrays.fill(dp, false);
            dp[0] = true;

            for (int num : nums)
                for (int i = sum; i > 0; i--)
                    if (i >= num)
                        dp[i] = dp[i] || dp[i-num];
            
            return dp[sum];
    }
}