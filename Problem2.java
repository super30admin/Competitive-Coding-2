//Knapsack from GFG

//Time Complexity: O(mn)
//Space Complexity: O(mn)

//Solution using tabulation approach (Bottom up DP)

public class MyClass {
    public static int findProfit(int[] wt, int[] val, int capacity){
        
        int[][] dp= new int[wt.length+1][capacity+1];
        
        for(int i =1; i<dp.length; i++){
             for(int j =1; j<dp[0].length; j++){
                 
                 if(j>=wt[i-1]){
                     //choose
                     dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                 }else{
                     //not choosen
                     dp[i][j]=dp[i-1][j];
                     
                 }
             }
        }
        return dp[wt.length][capacity];
    }
    public static void main(String args[]) {
        int capacity=7;
     int[] wt = {2,3,4,5};
     int[] val= {3,6,8,9};
     System.out.println(findProfit(wt, val, capacity));
    }
}