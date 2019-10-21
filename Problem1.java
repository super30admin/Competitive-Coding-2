//Knapsack Problem
//First Approach - Recursion (Brute Force Solution)
//The solution ran succesfully on leetcode playground
//Time Complexity-O(2^n)(This is because for each item we have 2 options of either choosing the item or not choosing the item)
//Space complexity-O[1](There is no extra space utilized, only recursive function is applied on the given arrays to obtain the output)
public class Main {
    public static int dp(int[] v,int[] w,int c,int n){
        // Recursion Base Case- If the size of the value array or the total capacity itself is zero
        if(n == 0 || c == 0) return 0;
        // Edge case- When the weight of a particular element considered is greater than that of the total capacity itself, then do recursion on rest of items and ignore this item
        if(w[n-1] > c){
            return dp(v,w,c,n-1);
        // Else take the possibility of the item considered and not considered and find the maximum among both the cases considered
        } else{
            return Math.max(v[n-1]+dp(v,w,c-w[n-1],n-1),dp(v,w,c,n-1));
        }
    }
    public static void main(String[] args) {
        int[] v = { 60, 100, 120 };
        int[] w = { 10, 20, 30 };
        int c = 30;
        int n = v.length;
        System.out.println(dp(v,w,c,n));        
    }
}
//Second Approach -Dynamic Programming (Optimized Solution)
//The solution ran successfully on leetcode playground
//Time Complexity-O(m*n)(This is because we are using 2 for loops to fill in the 2 dimensional array constucted)
//Space complexity-O[m*n](We optimize the repeating subproblems by using the previous computations in the (m*n) 2 dimensional array constucted)
public class Main {
    public static int dp(int[] v,int[] w,int c,int n){
        int dp[][] = new int[n+1][c+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=c;j++){
                // The initail row and column is intialzied with zeroes
                if(i==0||j==0){
                    dp[i][j] = 0;
                // If the column number of the matrix element is equal to or greater than that of the weight of item in the current row, then perform the maximum of the item considered and not considered
                } else if(j>=w[i-1]){
                    dp[i][j]=Math.max(v[i-1]+dp[i-1][j-w[i-1]],dp[i-1][j]);
                // Else copy the value of element above it in the matrix
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][c];
    }
    public static void main(String[] args) {
        int[] v = { 60, 100, 120 };
        int[] w = { 10, 20, 30 };
        int c = 50;
        int n = v.length;
        System.out.println(dp(v,w,c,n));
    }
}