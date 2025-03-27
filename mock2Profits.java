// "static void main" must be defined in a public class.
/* 
1. Given An Array of profits: {1,2,3}
2. Given an Array of weights: {4,5,1}
3. Given an extra variable as capacity = 5;
4. Given that the length of the arrays profits and weights is same
5. what is the maximum profit with no repeatitive weights and within the capacity
*/
public class mock2Profits {
    
    int[] p = {1,2,3}; //profits
    int[] w = {4,5,1}; //weights
    int n = w.length;
    int c = 5; //capacity
    int maxP;
    
    int[][] dp = new int[n+1][c+1];
    
    public void findMax(){
         //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // No capacity 0 profit
        }

        for (int j = 0; j <= c; j++) {
            dp[0][j] = 0; // No items left 0 profit
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=c;j++){
                if(j>=w[i-1]){
                    //choose
                    int case0 = dp[i-1][j-w[i-1]]+p[i-1];

                    //not choose
                    int case1 = dp[i-1][j];

                    dp[i][j] = Math.max(case0,case1);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        maxP = dp[n][c];
    }    
    public static void main(String[] args) {
        mock2Profits obj = new mock2Profits();
        obj.findMax();
        System.out.println("maximum profit is " + obj.maxP);
    }
}