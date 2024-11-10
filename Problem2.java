//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
class Problem2 {
    // Function to return max value that can be put in knapsack of capacity.
    //TC :O(N*M)
    //SC :O(N*M))
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here

        int m = val.length;
        int n = capacity;
        int [][] dp = new int[m+1][n+1];


        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int remCap = j - wt[i-1];

                //not chosen capacity remain same and previous max in DP 
                int notChosen = dp[i-1][j];
                int chosen = 0;
                if(remCap >=0){
                    chosen = val[i-1] + dp[i-1][remCap];
                }

                dp[i][j] = Math.max(notChosen,chosen);
            }
        }

        return dp[m][n];

        //return recurHelper(capacity,val,wt,0,0);
    }

    static int recurHelper (int capacity, int val[], int wt[] , int i,int profit){
        //base condition
        if(capacity<0){
            return 0;
        }
        if(i==wt.length){
            return profit;
        }
        //no chose 
        int noChose = recurHelper(capacity,val,wt,i+1,profit);

        int chose = 0;
        //int chose
        if(capacity-wt[i] >= 0){
            chose = recurHelper(capacity-wt[i],val,wt,i+1,profit+val[i]);
        }

        return Math.max(noChose,chose);





    }
}
