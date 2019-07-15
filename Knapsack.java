//Time Complexity - O(n*W) - n is number of weights and W is max capactiy of knapsack
// Space complexity - O(n*W)
// Dynamic Programming with knapsack approach


class Knapsack {

    public int calcKnapSack(int W, int wt[], int val[]){
        int[][] dp = new int[wt.length+1][W+1];
        
        //i - values ; j - current capacity of knapsack
        for(int i=1;i<=wt.length;i++){
            for(int j=1;j<=W;j++){
                if(j >= wt[i-1]){
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]],  dp[i-1][j]);
                    
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }       
        
        return dp[wt.length][W];
    }
    public static void main(String[] args){
        System.out.println("Knapsack");
        Knapsack obj = new Knapsack();
        int[] wt = {10,20,30};
        int[] val = {60, 100,120};
        int W = 50;

        System.out.println(obj.calcKnapSack(W, wt, val));
    }
}