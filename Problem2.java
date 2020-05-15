//W - capacity, wt - weights array, v - values array, res - max value
//Time - exponential
class Knapsack{
    public int knapsack(int W, int[] wt, int[] v){
        return helper(W,wt,v,0,0);
    }

    private int helper(int W, int[] wt, int[] v, int index,int res){
        //base case
        if(index >= wt.length || W==0)
            return res;
        if(wt[index] > W){
            return helper(W,wt,v,index+1,res);
        }

        //logic
        //not choosing
        int case1 = helper(W,wt,v,index+1,res);
        int case2 = helper(W-wt[index],wt,v,index+1,res + v[index]);
        return Math.max(case1,case2);
    }
}

//time o(mw)
//space o(mw) ,m - size of wt array, w is the weight capacity
// other solution
class Knapsack{
    public int knapsack(int W, int[] wt, int[] v){
        if(W==0 || wt == null || wt.length == 0)
        return 0;
        //length of weight array
        int wlen = wt.length;
        int[][] dp = new int[wlen+1][W+1];

        //leave first row and first column as 0's because we cannot manke any profits because of profit value 0  and weightvalue 0.
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j < wt[i-1]){
                   dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],v[i-1]+dp[i-1][W-wt[i-1]]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}