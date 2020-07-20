// Time Complexity :O(n^2)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

class Problem2{

    /**KnapSack 0/1 Max Value for weight */
    public static int maxValue (int[] val, int[] weight, int targetWeight){

        // edge condition
        if(targetWeight==0 || val==null || val.length==0 || weight==null 
             || weight.length==0 || val.length != weight.length)
            return 0;

        // row -> value
        // col -> target
        int[][] dp = new int[val.length+1][targetWeight+1];
        
        // intialize dp for zero weight
        for(int i=0; i<=val.length; i++)
            dp[i][0] = 0;
        
        // for greater than zero
        for(int j=1; j<=targetWeight;j++)
            dp[0][j] = 0;
        
        // iterate
        for(int i=1;i<=val.length;i++){

            for(int j=1;j<=targetWeight;j++){
                // target less than current value weight
                if(j< weight[i-1])
                    dp[i][j] = dp[i-1][j];
                // else find max previous calculate
                else
                    dp[i][j] = Math.max(dp[i-1][j], (val[i-1]+ dp[i-1][j-weight[i-1]]));
            }
        }
        // max 
        return dp[val.length][targetWeight];

    }

    public static void main(String[] args) {
        int val[] = new int[] { 1, 6, 18, 22, 28 }; 
        int wt[] = new int[] { 1, 2,5,  6, 7 }; 
        int W = 11; 
        System.out.println(maxValue(val,wt, W)); 
    }
}