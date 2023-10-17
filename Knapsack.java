// TC will be O(n * target)
//SC will be O(target)

class Knapsack {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum || (target + sum) % 2 == 1) {
            // If the target is not achievable based on the sum of elements or
            // if the (target + sum) is odd, there are no valid expressions.
            return 0;
        }

        int subsetSum = (target + sum) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // There is one way to achieve a sum of 0 (by not selecting any number).

        for (int num : nums) {
            for (int i = subsetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[subsetSum];
    }

    public static void main(String[] args){
        Knapsack obj = new Knapsack();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        obj.findTargetSumWays(nums,target);
    }
}
