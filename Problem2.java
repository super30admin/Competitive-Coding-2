//Problem 2 - https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Competitive_Coding_2


package S30_Codes.Competitive_Coding_2;

import java.util.HashMap;
import java.util.Map;

class Knapsack01 {

    public static void main(String args[])
    {
        int profit[] = new int[] { 500, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int capacity = 50;

        System.out.println(knapSack(capacity, weight, profit));
    }

    static int knapSack(int capacity, int wt[], int val[])
    {
        return maxProfit(val, wt, capacity, 0, 0, 0);
    }

    static int maxProfit(int profit[], int weight[], int capacity, int idx, int curWeight, int curProfit){
        if(idx >= profit.length || curWeight > capacity){
            return curProfit;
        }

        int pf1 = maxProfit(profit, weight, capacity, idx+1, curWeight, curProfit);

        int pf2 = 0;
        if(curWeight + weight[idx] <= capacity){
            curWeight += weight[idx];
            curProfit += profit[idx];
            pf2 = maxProfit(profit, weight, capacity, idx+1, curWeight, curProfit);
        }

        return  Math.max(pf1, pf2);
    }
}
