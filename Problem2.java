//Time Complexity - O(n * m)
//Space Complexity - O(n * m)
//Approach - Take the number of items as the rows and the Capacity as the columns. 
// Whenever the value at j is < the individual item's weight ( wt[i-1]) , we simply go with case0 and do not include it. 
//Otherwise find the max of case0 and case1. 
import java.util.*;
public class Problem2 {
    static int knapSack(int C, int[] wt, int[] p, int n){

        int[][] dp = new int[n+1][C+1];
        int i = 0, j=0;
        for(i = 0; i < n +1; i++){
            for(j = 0; j < C +1;j++){
                if( i== 0|| j==0){
                    dp[i][j] = 0;
                }
                else if( wt[i-1] > j){
                    dp[i][j] = dp[i-1][j];  //case0
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - wt[i-1]] + p[i-1]);
                }

            }
        }
        return dp[n][C];


    }
    public static void main(String[] args){
        int C = 6;
        int[] wt = {1,2,3};
        int[] p = {10,15,40};
        int n = 3;
        int profit = knapSack(C,wt,p,n);
        System.out.println(profit);
    }

    
}

//Without a 2D DP table 
//Time complexity remains the same. 
//Space - O(n)
// import java.util.*;

// class KnapSackSolution{
//     static int knapSack(int C, int wt[], int p[], int n)
//     {

//         int[] dp = new int[C + 1];

//         for (int i = 1; i < n + 1; i++) {
//             for (int j = C; j >= 0; j--) {

//                 if (wt[i - 1] <= j){
//                     dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + p[i - 1]);
//                 }
//             }
//         }
//         return dp[C];
//     }

//     public static void main(String[] args)
//     {
//         int C = 6;
//         int[] wt = {1,2,3};
//         int[] p = {10,15,40};
//         int n = p.length;
//         System.out.println(knapSack(C, wt, p, n));
//     }
// }
