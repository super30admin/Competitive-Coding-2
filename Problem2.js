//0/1 knapsack Problem
function knapsack(W, val, wt, n = wt.length) {
    //**Time Complexity : O(2^N) */
    //**Space Complexity : O(N) */
        if (n === 0 || W === 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            let include = val[n - 1] + this.knapsack(W - wt[n - 1], val, wt, n - 1);
            let exclude = this.knapsack(W, val, wt, n - 1);
            return Math.max(include, exclude);
        } else {
            return this.knapsack(W, val, wt, n - 1);
        }
}
