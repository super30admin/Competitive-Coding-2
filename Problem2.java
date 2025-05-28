class Solution {
    static int dp[][];
    static int knapsack(int W, int val[], int wt[]) {
        dp = new int[wt.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return helper(wt,0,W,val);
    }
    static int helper(int a[], int idx, int W, int val[]){
        //base
        if(idx>=a.length || W<=0){
            dp[idx][W] = 0;
            return 0;
        }
        if(dp[idx][W] != -1){
            return dp[idx][W];
        }
        // if(a.length-idx == 1 && ){

        // }

        //logic
        //dont choose
        int c1 = 0;
        c1 = helper(a,idx+1,W, val);
        int c2=0;
        if(W-a[idx] >= 0 ){
            c2 = val[idx]+ helper(a,idx+1,W-a[idx], val);
        }

        int ret = Math.max(c1,c2);
        dp[idx][W] = ret;
        // System.out.println(idx +" "+ W+" "+ret);
        return ret;
        //choose

    }
}
