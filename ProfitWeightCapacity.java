// through DP
public class ProfitWeightCapacity {
    public static void main(String[] args) {
        int[] profit = {60,100,120};
        int[] weight = {10, 20, 30};
        int capacity = 50;
        
        int m = weight.length;
        int n = capacity;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=1; i<=m;i++){
            for(int j=1; j<=n; j++){
                if(j < weight[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], profit[i-1]+dp[i-1][j-weight[i-1]]);
                }
            }
        }

        System.out.println(dp[m][n]);
    }      
}


// Through recursion
// public class ProfitWeightCapacity {
//     public static void main(String[] args) {
//          int[] profit = {60,100,120};
//         int[] weight = {10, 20, 30};
//         int capacity = 50;

//         System.out.println(helper(profit, weight, capacity, 0, 0));
//     }
    
//       private static int helper(int[] profit, int[] weight, int capacity, int i, int totalProfit) {
//         //base case
//         if(i>=weight.length) {
//             return totalProfit;
//         }

//         //logic
//         int case0= helper(profit, weight, capacity, i+1, totalProfit);

//         int case1=0;
//         if(weight[i] <=capacity) {
//             case1= helper(profit, weight, capacity-weight[i], i, totalProfit+profit[i]);
//         }

//         return Math.max(case0, case1);
//     }
// }