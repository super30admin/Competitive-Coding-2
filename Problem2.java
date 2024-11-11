// Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}

// Approach : Recursive Approach . Choose and donotChoose weights
// Time : 2^(weights+profit) 
// Space: O(m+n)

// Driver code
public class Main{
    public static void main(String args[])
    {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int capacity = 50;

        System.out.println(helper(profit, weight, capacity, 0,0));
    }

    private static helper(int[] profit,int[] weight,int capacity,int i,int max_profit ){
        // base case - no more weights left
        if(i>=weight.length) return max_profit;
        
        // logic
        int notChoose = helper(profit,weight,capacity,i+1,max_profit);

        int choose = 0;

        if(weight[i]<=capacity){
            choose = helper(profit,weight,capacity-weight[i],i+1,max_profit+profit[i]);
        }   
        
        return Math.max(choose,notChoose);
    }
}

// Approach : DP with tabulation.
// Time : O(m*n)
// Space: O(m+n)

/ Driver code
public class Main{
    public static void main(String args[])
    {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int capacity = 50;

        int m = weights.length; //3
        int n = capacity;

        int[][] dp = new int[m+1][n+1]; // consider 0 weight and 0 profit then add lengths+1

        // default fill first row and first column with zeros
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j<capacity){
                    // current weight is greater than capacity. Choose case is not available.
                    dp[i][j] = dp[i-1][j-1]; // no choose case
                } else{
                    // choose the max between choose and no choose case
                    dp[i][j]=Math.max(dp[i-1][j],profit[i]+dp[i-1][j-weight[i-1]]);
                }
            }
        }
        return dp[m][n];
    }

    
}

