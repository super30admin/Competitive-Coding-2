// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        
        int[] wts = { 60, 40, 20 ,30};
        int[] score = { 1000, 180, 100, 120};
        int capacity = 50;
        
        // System.out.println(knapsack2(score, wts, capacity));
        System.out.println(knapsack(score, wts, capacity, 0, 0));
        
    }
    
    public static int knapsack(int[] score, int[] items, int capacity, int maxScore, int index) {
        // base 
        if(index == score.length || capacity < 0)  {
            return maxScore;
        }
        
        // logic
      
        int case1 = knapsack(score, items, capacity - items[index], maxScore + score[index], index + 1);
        int case2 = knapsack(score, items, capacity, maxScore, index + 1);
        
        if(capacity < items[index]) {
            return case2;            
        }
        
        return Math.max(case1, case2);
    }
    
    public static int knapsack2(int[] score, int[] items, int capacity) {
        
        if(items == null || items.length== 0 || score == null || score.length == 0) {
            return -1;
        }
        
        int[][] dp = new int[items.length+1][capacity+1];
        
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(items[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], score[i-1] + dp[i-1][j-items[i-1]]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[items.length][capacity];
    
    }
}
