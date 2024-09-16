
// Time Complexity :O(n^2),where n is the number of weights and capacity together

// Space Complexity :O(n^2), where n is the number of weights and capacity together
// Did this code successfully run on Leetcode : 
// Three line explanation of solution in plain english:
//at each step we decide whether to include or exclude the current weight and
//aslo check if the weight in crossing the capacity
// 
public class Knapsack {

  //method 1 - 
  //recurisve appraoach with exponential time
    //   public int solveKnapsack(int[]profits, int[]weights,int capacity){
    //       return recursiveKnap(profits,weights,capacity,0);
    //   }

    // private int recursiveKnap(int[] profits, int[] weights, int capacity, int index) {
    //     if (capacity <= 0 || index >= profits.length){
    //         return 0;
    //     }

    //     int include = 0;
    //     if (weights[index] <= capacity){
    //         include = profits[index]+recursiveKnap(profits,weights,capacity-weights[index],index+1);
    //     }

    //     int exclude = recursiveKnap(profits,weights,capacity,index+1);

    //     return Math.max(include,exclude);
    //   }

  //dp approach with O(n^2 )time and O(n^2) space
    public int solveKnapsack(int []profits,int[]weights,int capacity){
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length){
            return 0;
        }
        int[][]dp = new int[profits.length][capacity + 1];
        for (int i =0;i < profits.length;i++){
            dp[i][0] = 0;
        }

        for (int i = 0; i < capacity+1 ; i++){
            if (weights[0] <= i){
                dp[0][i] = profits[0];
            }
        }

        for (int i =1; i < profits.length;i++){
            for (int j =1;j <=capacity;j++){
                int profit1 =0;
                int profit2 =0;

                if (weights[i] <= j){
                    profit1 = profits[i] + dp[i-1][j - weights[i]];

                }
                profit2 = dp[i-1][j];

                dp[i][j] = Math.max(profit1,profit2);
            }
        }
       
        return dp[profits.length-1][capacity];
    }



    public static void main(String[] args) {
          Knapsack ks = new Knapsack();
          int[]profits = {60,100,120};
          int[]weights = {10,20,30};
          int maxProfit = ks.solveKnapsack(profits,weights,50);
        System.out.println(maxProfit);
    }


}
