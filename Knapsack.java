/*
TC: O(R * C); R - length of weights array, C - max weight
SC: O(R * C); 

1. We need to either fill the weight or do not fill. 
2. If we do not fill the weight, then dp[i][j] will remain as is as previous row. 
3. If we choose, it will sum of value associated with weight +  value of the column weighing ‘j-wi’. 
4. Choose the max of 2 & 3 to fill each box.

*/

public class Knapsack{

    public int knapsack(int[] weight, int[] value, int maxW){

        int r = weight.length + 1, c = maxW + 1;
        
        int[][] dp = new int[r][c];

        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(j - weight[i-1] >= 0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[r - 1][c - 1];
    }

    public static void main(String[] args){
        int[] weight = new int[]{10 , 20 , 30};
        int[] value = new int[]{60 , 100 , 120};
        int maxW = 50;
        
        Knapsack ks = new Knapsack();
        System.out.println(ks.knapsack(weight, value, maxW));
    }

}