// Time Complexity : O(m*n) where m is length of profit/weight array and n is the capacity (target)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/* https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/*/
public class Main {

    static int knapSack(int[] profit, int[] weight, int capacity, int n){
        if(weight == null || weight.length == 0 || profit.length == 0 || profit == null)
            return 0;

        int[][] dp= new int[n+1][capacity+1];


        //remaining table
        for(int i = 0 ; i < n+1 ; i++){
            for(int j = 0 ; j < capacity+1 ; j++){

                //top row and left column of the table
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    System.out.println("i is :" + i + " j is: " + j + " value in i and j  " + dp[i][j]);
                }

                else if(j < weight[i-1]){
                    // till weights => capacity, copy as it is from above row
                    dp[i][j] = dp[i-1][j];
                    System.out.println("i is :" + i + " j is: " + j + " value in i and j  " + dp[i][j]);

                }

                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i-1]] + profit[i-1]);
                    System.out.println("i is :" + i + " j is: " + j + " value in i and j  " + dp[i][j]);

                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String args[])
    {
        int profit[] = new int[] { 1,2,6 };
        int weight[] = new int[] { 2,3,5 };
        int capacity = 8;
        int n = profit.length;
        System.out.println(knapSack(profit,weight,capacity,n));
    }
}
/*
//Brute Force Method TC: O(2^n) since at every step we have 2 choices to make
public class Main {

    static int knapSack(int[] profit, int[] weight, int capacity, int n){
        if(weight == null || weight.length == 0 || profit.length == 0 || profit == null)
            return 0;
        return helper(profit,weight,capacity, n , 0 , 0);
    }
    static int helper(int[] profit, int[] weight,int r_capacity, int n, int i, int max){

        //base case
        if(i >=n  || r_capacity ==0)
            return max;
        //logic
        if(weight[i] > r_capacity)
            return helper(profit, weight,r_capacity, n , i+1, max);
        //choose
        int case1 = helper(profit, weight,r_capacity-weight[i], n , i+1, max + profit[i]);

        //not-choose
        int case0 = helper(profit, weight,r_capacity, n , i+1, max );

        return Math.max(case1,case0);
    }

    public static void main(String args[])
    {
        int profit[] = new int[] { 60,100,120 };
        int weight[] = new int[] { 10,20,30 };
        int capacity = 50;
        int n = profit.length;
        System.out.println(knapSack(profit,weight,capacity,n));
    }
}
*/