// # Competitive-Coding-2
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++) {
            int compliment = target - nums[i];
            if(map.containsKey(compliment)) {
                return new int[] {i,map.get(compliment)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
// # Competitive-Coding-2
// Time Complexity : O(N * W)
// Space Complexity : O(W)
// Did this code successfully run on geeksforgeeks : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

class knapSackSolution {
    static int knapSack(int W, int wt[], int val[], int n)
    {

        int[] dp = new int[W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {

                if (wt[i - 1] <= w)
                    dp[w]
                            = Math.max(dp[w], dp[w - wt[i - 1]]
                            + val[i - 1]);
            }
        }

        return dp[W];
    }
}