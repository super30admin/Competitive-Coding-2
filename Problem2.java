// Time Complexity: O(2^n) — since we have two choices (pick or not pick) for each item
// Space Complexity: O(n) 
// Did this code successfully run on Leetcode: Not available on Leetcode as-is, but the logic is correct
// Any problem you faced while coding this: No

// Approach:
// At each index, we have two choices — either we pick the item (if it fits), or we skip it.
// We recursively explore both choices and return the maximum profit.
// Base case is when capacity is 0 or we’ve considered all items




public class Problem2 {
    public int knapsack(int[] profit, int[] weight, int W){
        if(profit==null || weight==null || profit.length==0 || weight.length ==0){
            return 0;
        }
        return recurse(profit, weight, W, 0);
    }
    private int recurse(int[] profit, int[] weight, int capacity, int index){
        //Base Case
        if(index == profit.length || capacity<=0){
            return 0;
        }
        if(weight[index]>capacity){
            return recurse(profit, weight, capacity, index+1);
        }
        int case1 = recurse(profit, weight, capacity, index+1);
        int case2 = profit[index] + recurse(profit, weight, capacity-weight[index], index+1);

        return Math.max(case1, case2);
    }

    public static void main(String[]args){
        Problem2 ob = new Problem2();
        int[] profit1 = {1, 2, 3};
        int[] weight1 = {4, 5, 1};
        int W1 = 4;
        System.out.println("Max Profit = " + ob.knapsack(profit1, weight1, W1));  

        int[] profit2 = {1, 2, 3};
        int[] weight2 = {4, 5, 6};
        int W2 = 3;
        System.out.println("Max Profit = " + ob.knapsack(profit2, weight2, W2));
    }
    
}
