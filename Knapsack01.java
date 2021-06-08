package CompetitiveCoding2;

public class Knapsack01 {

    /*
    Brute Force :
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    private static int bruteForceKnapSack(int[] weights, int[] values,  int weightAvailable,
                                          int totalProfit, int index) {
        //Base Case
        if(index >= weights.length || weightAvailable == 0) return totalProfit;

        if(weights[index] > weightAvailable)
            return bruteForceKnapSack(weights, values, weightAvailable, totalProfit, index+1);
        //Logic
        //If I choose the weight
        int case1 = bruteForceKnapSack(weights, values, weightAvailable - weights[index],
                totalProfit + values[index], index + 1);

        //If I do not choose the weight
        int case2 = bruteForceKnapSack(weights, values, weightAvailable, totalProfit, index + 1);

        return Math.max(case1, case2);
    }

    /*
    Dynamic Programming :
        Time Complexity:
        Space Complexity:
     */


//    private static int dpKnapSack(int[] weights, int[] values, int weightAvailable, int totalProfit, int dp[][], int index) {
//        if(weights == null || values == null || weights.length == 0 || values.length == 0) return 0;
//
//        if(index >= weights.length || weightAvailable == 0) return totalProfit;
//
//        if(weights[index] > weightAvailable)
//            return bruteForceKnapSack(weights, values, weightAvailable, totalProfit, index+1);
//        //Logic
//        //If I choose the weight
//        int case1 = bruteForceKnapSack(weights, values, weightAvailable - weights[index],
//                totalProfit + values[index], index + 1);
//
//        //If I do not choose the weight
//        int case2 = bruteForceKnapSack(weights, values, weightAvailable, totalProfit, index + 1);
//
//        dp[index][weightAvailable] = Math.max(case1, case2);
//
//        return dp[index][weightAvailable];
//    }

    public static void main(String[] args) {
        // Print the maximum profit by picking up the weights which can be Max 50.
        // It can be less also if the profit is high

        int[] weights = {10, 10, 20, 30, 60};
        int[] values = {60, 60, 100, 120, 140};
//        int[] weights = {10, 20, 30};
//        int[] values = {60, 100, 120};
        int index = 0;
        int weightAvailable = 50;
        int totalProfit = 0;

        System.out.println(bruteForceKnapSack(weights, values, weightAvailable, totalProfit, index));

//        int dp[][] = new int[weightAvailable + 1][weights.length + 1];
//        System.out.println(dpKnapSack(weights, values, weightAvailable, totalProfit, dp, 0));
    }
}