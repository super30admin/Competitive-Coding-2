//0-1 Knapsack Problem
// Time: O(n*m) where m is target
// Space: O(n*m) where m is target

/// Approach
// Create a dp array of size [lenght of w array][target+1]. The index will always lie between ‘0’ and ‘n-1’. The capacity can take any value between ‘0’ and ‘target’. Itialize the dp array to -1.
// Whenever we want to find the answer of particular parameters, we first check whether the answer is already calculated using the dp array. If yes, simply return the value from the dp array.
// If not, find the answer for the given value for the first time, we will use the recursive relation as usual but before returning from the function, we will set dp[index][target] to the answer we get.

public class Main {
    public static void main(String[] args) {
        int target = 50;
        int w[] = {10, 20, 30};
        int v[] = {60, 100, 120};
        int len_w = w.length;
        knapsack(w, v, len_w, target);
        System.out.println("The Maximum weight "+ knapsack(w, v, len_w, target));
    }
    //helper function
    static int knapsack(int[] w, int[] v, int len_w, int target){
        int dp[][]= new int[len_w][target+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return utility(w, v, len_w-1, target, dp);
    }
    static int utility(int[] w, int[] v, int index, int target, int[][] dp){
        if(index == 0){
            if(w[0] <= target)
                return v[0];
            else
                return 0;
        }
        if(dp[index][target]!=-1)
            return dp[index][target];
        int notTaken = 0 + utility(w, v, index-1, target, dp);
        int taken = Integer.MIN_VALUE;
        if(w[index] <= target)
            taken = v[index] + utility(w, v, index-1, target-w[index], dp);
        return dp[index][target] = Math.max(notTaken,taken);
    }
}