public class Knapsack{
    public static int knapsack(int []profit, int[] weight, int W, int index){
        if (index == 0 || W ==0)
            return 0;
        if(weight[index -1] > W)
            return knapsack(profit, weight, W, index-1);

        int include = profit[index-1] + knapsack(profit, weight, W - weight[index-1], index-1);
        int exclude = knapsack(profit, weight, W, index-1);
        return Math.max(include, exclude);
    }

    public static void main(String args[]){
        int[] profit = {1, 2, 3};
        int[] weight = {4, 5, 1};
        int W = 4;
        int n = profit.length;

        int maxProfit = knapsack(profit, weight, W, n);
        System.out.println("Maximum Profit: " + maxProfit);  // Output: 3

    }
}