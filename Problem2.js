// Time Complexity:  Recursive: O(2^n) DP: O(m x n)  m is number of elem and n is capacity 
// Space Complexity:  DP: O(m x n)  m is number of elem and n is capacity 
//Runs: Yes
//// Any problem you faced while coding this : Understanding the math.max parameters.

//Recursive Approach:
class Solution {

    knapSack(W, wt, val, n) {
        return this.helper(W, wt, val, n, 0, 0);
    }

    helper(W, wt, val, n, index, max_profit) {

        // base
        if (index >= n || W === 0) return max_profit;
        //Logic
        if (wt[index] > W) return this.helper(W, wt, val, n, index + 1, max_profit);

        //Choose
        let case1 = this.helper(W - wt[index], wt, val, n, index + 1, max_profit + val[index]);

        //Not Choose
        let case2 = this.helper(W, wt, val, n, index + 1, max_profit);
        return Math.max(case1, case2);
    }


}



//DP Approach 

class Solution {
    knapSack(W, wt, val, n) {
        var dp = new Array(n + 1);
        for (let i = 0; i < dp.length; i++) {
            dp[i] = new Array(W + 1);
            dp[i][0] = 0;
        }
        for (let j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (let i = 1; i < dp.length; i++) {
            for (let j = 1; j < dp[0].length; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];

    }
}