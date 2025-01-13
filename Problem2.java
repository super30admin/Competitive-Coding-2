// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode :yes

// Your code here along with comments explaining your approach
// tabulation approach using 2d array based on params that are changing


class Knapsack01 {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int cap, int val[], int wt[]) {
        if(wt == null || wt.length ==0 || val == null || val.length == 0){
            return 0;
        }

        int[][] memo = new int[wt.length+1][cap+1];
        for(int i=1;i<wt.length+1;i++){
            for(int j=1;j<cap+1;j++){
                if(j < wt[i-1]){
                    memo[i][j] = memo[i-1][j];
                }else{
                    //System.out.println("i "+i+" j "+j);
                    memo[i][j] = Math.max(memo[i-1][j],val[i-1]+ memo[i-1][j- wt[i-1]]);
                }
            }
        }
        return memo[wt.length][cap];
    }
}
