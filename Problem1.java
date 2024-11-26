/**
 * 0/1KnapSack  -   Same as Coin Change 1 --consider , dont consider with constraint on weight
 * TC: O(2^n) n - length of the weights array
 * SC: O(n)
 */
class Problem1{
    public static int findMaxCap(int W,int[] wt,int[] val, int n,int max){
        if(wt == null|| val == null || wt.length == 0 || val.length == 0 || wt.length != val.length) return 0;

        //base
        if(n==wt.length || W==0) return max;
        //choose
        int case1 = 0;
        if(wt[n] <= W)
            case1 = findMaxCap(W-wt[n],wt,val,n+1,max+val[n]);
        //dont choose
        int case2 = findMaxCap(W,wt,val,n+1,max);
        return Math.max(case1,case2);
    }
    public static void main(String[] args){
        int[] wt = new int[] {10,20,30};
        int[] val = new int[] {60,100,120};

        System.out.println(findMaxCap(50,wt,val,0,0));
    }
}

/**
 * Iterative Approach - DP TC:O(m*n) m- wt.length and n - W SC: O(m*n)
 */
class Trial{
    public static int findMaxCap(int[] wt, int[] val, int W){
        int[][] dp =new int[wt.length][W+1];

        for(int i=0;i<wt.length;i++)            // first col for restricted Weight of 0
            dp[i][0] = 0;
        for(int i=1;i<=W;i++){                 // first row where wt[0] is considered
            if(wt[0] <= i)
                dp[0][1] = val[0];
        }
        for(int i=1;i<wt.length;i++){
            for(int j=1;j<=W;j++){
                if(wt[i] <= j)              //if current row(wt[i]) is lesser than j(expected weight) then max of previous row val of asme coln or current weights val and remaining weight's optimal values from previous row
                    dp[i][j] = Math.max(val[i] + dp[i-1][j-wt[i]],dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[wt.length-1][W];
    }
    public static void main(String[] args){
        int[] wt = new int[] {10,20,30};
        int[] val = new int[] {60,100,120};

        System.out.println(findMaxCap(wt,val,50));
    }
}