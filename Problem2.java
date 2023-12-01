import java.util.Arrays;

class Knapsack{
//    Time Complexity: O(2 ^ n)
//    Space Complexity: O(n)
    public static int knapsackRecursive(int n, int W, int profit[], int weight[]){
        if(n == 0 || W == 0) return 0;

        if(weight[n-1] > W) return knapsackRecursive(n-1, W, profit, weight);

        else return Math.max( knapsackRecursive(n-1, W - weight[n-1], profit, weight) + profit[n-1],
                knapsackRecursive(n-1, W, profit, weight));

    }

//    2d array
//    Time Complexity: O( N * W)
//    Space Complexity: O(N * W)
    private static int knapsackDynamic2d(int n, int w, int[] profit, int[] weight) {

        int dp[][] = new int[n+1][w+1];

        for(int i=0; i<= n; i++){
            for(int j=0; j<=w; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(weight[i-1] <= j){
                    dp[i][j] = Math.max(profit[i-1] + dp[i-1][j - weight[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
//            System.out.println(Arrays.deepToString(dp));
        }

        return dp[n][w];
    }


//    1d array
//    Time Complexity: O( N * W)
//    Space Complexity: O(W)
    private static int knapsackDynamic1d(int n, int w, int[] profit, int[] weight) {

        int dp[] = new int[w+1];

        for(int i=1; i<= n; i++){
            for(int j=w; j>=0; j--){
                if(weight[i-1] <= j){
                    dp[j] = Math.max(profit[i-1] + dp[j - weight[i-1]], dp[j]);
                }
            }
        }


        return dp[w];
    }


    public static void main(String[] args) {
        int N = 3, W = 50;
        int profit[] = {60, 100, 120};
        int weight[] = {10,20, 30};

//        int N = 3, W = 4;
//        int profit[] = {1,2,3};
//        int weight[] = {4,5,1};

        System.out.println("Maximum profit: " + knapsackRecursive(N, W, profit, weight));

        System.out.println("Maximum profit: " + knapsackDynamic2d(N, W, profit, weight));

        System.out.println("Maximum profit: " + knapsackDynamic1d(N, W, profit, weight));


    }


}