/*
time complexity: O(W*V) where w is the length og Weights array and
                V is the length of the values Arrays
space complexity : O(W*V) w and v stand for the same as mentioned above

problems faced: yes in finalizing the dp.

*/


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] W = {10, 20, 30};
        int[] V = {160, 100, 120};
        int capacity = 50;
        System.out.println(knapsack(W,V,capacity));
    }

    public static int knapsack(int[] W, int[] V, int capacity){

        int len1 = W.length;

        int len2 = V.length;

        int[][] dp = new int[len1+1][capacity+1];

        for(int row = 1; row < len1+1; row++){
            for(int col = 1; col < capacity+1; col++){
                if(col < W[row-1])
                    dp[row][col] = dp[row-1][col];
                else{
                    dp[row][col] = Math.max(dp[row-1][col],
                                            dp[row-1][col - W[row-1]] + V[row-1]);
                }
            }
        }

        return dp[len1][capacity];

    }


}
