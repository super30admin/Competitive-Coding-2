//time complexity 0(M*N) - iterating through input array to build dp matrix
//space complexity O(M*N) - creating a new dp matrix

class KnapSack {
    //*****Exhaustive approach */
    // public static int[] weights = {1,2,3};
    // public static int[] costs = {60,100,120};
    // public static int maxWeight = 5;
    // public static void main(String[] args) {
    //     int re = helper(0, maxWeight);
    //     System.out.println(re);
    // }
    // public static int helper(int i, int maxWeight){
    //     if( i >= weights.length || maxWeight<=0 ) return 0;
    //     //no choose
    //     int case1 = helper(i+1, maxWeight);
    //     //choose
    //     int case2  = 0;
    //     if (maxWeight-weights[i]  >=0){
    //         case2 = costs[i]+ helper(i+1, maxWeight-weights[i]);
    //     }
    //     return Math.max(case1, case2);
    // }

    public int knapSack(int[] weights, int[] values, int maxWeight){
        int m = weights.length+1;
        int n = maxWeight+1;
        int[][] dp = new int[m][n];
        for(int j=0;j<n;j++){
             dp[0][j] = 0;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(j<weights[i-1]){
                    dp[i][j]=dp[i-1][j];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
     public static void main(String[] args) {
       KnapSack obj = new KnapSack();
       int[] w = {1,2,3,};
       int[] v = {160,100,120};
       System.out.println(obj.knapSack(w, v, 5));
    }
}