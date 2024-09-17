//Time complexity - O(m*n)
//Space Complexity - O(m*n)
//Dynamic programming


public class KnapSack {

    public static int knapSack(int maxCapacity, int weightsArr[], int valuesArr[],int n) {

        //null case
        if(weightsArr == null || valuesArr == null || valuesArr.length == 0|| weightsArr.length == 0) {
            return 0;
        }
       // create new matrix to hold the profit
       int dp[][] = new int[n+1][maxCapacity+1];
        for(int i = 0; i < n+1; i++) {
            for (int j = 0; j< maxCapacity+1; j++) {
                if(i==0 || j== 0) {
                    dp[i][j] = 0;
                } else if( j< weightsArr[i-1]) {
                    //if the weight is less than capcity then copy the values from above 
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weightsArr[i-1]]+valuesArr[i-1]);
                }
            }
        }

        return dp[n][maxCapacity];


    }

    public static void main(String[] args) {

        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}


