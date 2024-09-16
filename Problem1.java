class Solution{
    
    //dp[i][j] = the maximum value i get after I chose i items and filled j
    //weight
    // if(item's weight < W-j)
    // dp[i][j] = Max (dp[i][j-wi],
    //            dp[i-1][j])
    // dp[0][j] = 0
    // dp[i][0] = 0
    public static int maxBagValue(int[]value, int[]weights,int W){
        int m = weights.length;
        int[][] dp = new int[m+1][W+1];
        for(int i=1;i<=m;i++){ //m =3
            for(int j=1;j<=W;j++){ //j=50
                dp[i][j] =  Math.max(dp[i-1][j],j-weights[i-1]>=0?(dp[i-1][j-weights[i-1]] + value[i-1]):0);
            }
        }
        return dp[m][W];
    }

       //int value[] = new int[] {60, 100, 120}; 
        //int weights[] = new int[] {10, 20, 30}; 
        //int W = 50;

     public static void main(String args[]){
         int value[] = new int[] {60, 100, 120}; 
        int weights[] = new int[] {10, 20, 30}; 
        int W = 50;
        System.out.println(Solution.maxBagValue(value,weights,W));
     }

}
