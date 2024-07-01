// Time Complexity : O(W*n);
// Space Complexity : O(W*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Used dp technique to find the maximum value for given weights as taught in class. 


function knapsack(W, wt, val, n)
{
    let dp = new Array(n+1);

    for(let i=0; i<=n; i++){
        dp[i] = new Array(W+1);
        for(let j=0;j<=W;j++){
            if(j==0 || i==0)
                dp[i][j]=0;
            else {
                if(j<wt[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
            }
        }
    }
    return dp[n][W];
}

let values = [ 60, 100, 120 ];
let weight = [ 10, 20, 30 ];
let W = 50;
let n = values.length;
console.log(knapsack(W, weight, values, n));