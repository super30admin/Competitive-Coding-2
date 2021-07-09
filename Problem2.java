// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Knapsack{

    //checks and returns the max value between two elements
    public static int max(int a, int b){
        if( a > b){
            return a;
        }
        else{
            return b;
        }
    }

    public static int knapsack(int W, int[] weight, int[] value, int n){

        //base case: capacity or the number of items is 0
        if(n == 0 || W == 0){
            return 0;
        }

        //if the element we are looking at is larger than the capacity then we cannot take it
        //so we move on to the next value
        if(weight[n - 1] > W){
            return knapsack(W, weight, value, n - 1);
        }

        //we return whichever is better: the current item included or not included
        else{
            return max(value[n - 1] + knapsack(W - weight[n - 1], weight, value, n - 1), knapsack(W, weight, value, n - 1));
        }
    }

    public static void main(String args[])
    {
        int value[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = value.length;
        System.out.println(knapsack(W, weight, value, n));
    }
}