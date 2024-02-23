// Time Complexity : O(n * m) [n = weight.length; m = capacity]
// Space Complexity : O(2m)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this : Kind off, was able to relate to coin change problem by imagining data capacity as target

// Your code here along with comments explaining your approach

public class KnapSacK01 {

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {


        // return helperRecursion(weight, value, n-1, maxWeight);


        //Two-D array since idx and capacity will keep on changing
        // int [][] dp = new int [n][maxWeight + 1];
        // for(int [] arr: dp) {
        //     Arrays.fill(arr, -1);
        // }

        // return helperMemoization(weight, value, n-1, maxWeight, dp);

        // return helperTabulation(weight, value, n, maxWeight);

        return helperOptimizedTabulation(weight, value, n, maxWeight);

    }
    
     private static int helperOptimizedTabulation(int[] weight, int[] value, int n, int capacity) {

        //created dp array with prev and current
        int [] prev = new int [capacity + 1];
        int [] current = new int [capacity + 1];

        //base case from recursion
        //Also transform the array to have the values
        for(int w = weight[0]; w <=capacity; w++) {
            if(weight[0] <= capacity) {
                prev[w] = value[0];
            }else {
                prev[w] = 0;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int w = 0; w <= capacity; w++) {
                int choose = 0;
                if (weight[i] <= w) {
                    choose = value[i] + prev[w - weight[i]];
                }
                int notChoose = 0 + prev[w];
                current[w] = Math.max(choose, notChoose);
            }
            prev = current;
            current = new int[capacity+1];
        }

        return prev[capacity];

    }


//     private static int helperTabulation(int[] weight, int[] value, int n, int capacity) {

//         //created dp array
//         int [][] dp = new int [n][capacity + 1];

//         //base case from recursion
//         for(int w = weight[0]; w <=capacity; w++) {
//             if(weight[0] <= capacity) {
//                 dp[0][w] = value[0];
//             }else {
//                 dp[0][w] = 0;
//             }
//         }


// //
//         for(int i = 1; i < n; i++) {
//             for(int w = 0; w <= capacity; w++) {
//                 int choose = 0;
//                 if (weight[i] <= w) {
//                     choose = value[i] + dp[i -1][w - weight[i]];
//                 }
//                 int notChoose = 0 + dp[i-1][w];
//                 dp[i][w] = Math.max(choose, notChoose);
//             }
//         }

//         return dp[n - 1][capacity];

//     }

    // private static int helperMemoization(int[] weight, int[] value, int idx, int capacity, int [][] dp) {

    //     //base case
    //     //If only one item, then check with the capacity
    //     if (idx == 0) {
    //         if(weight[0] <= capacity) {
    //             return value[0];
    //         }else {
    //             return 0;
    //         }
    //     }

    //     if(dp[idx][capacity] != -1) {
    //         return dp[idx][capacity];
    //     }

    //     //choose
    //     //current value of the included weight + recursive solution of the remaining weights    
    //     int choose = 0;
    //     if (weight[idx] <= capacity) {
    //         choose = value[idx] + helperMemoization(weight, value, idx -1, capacity - weight[idx], dp);
    //     }

    //     //Not choose
    //     //current index not included then 0 value + + recursive solution of the remaining weights 
    //     int notChoose = 0 + helperMemoization(weight, value, idx-1, capacity, dp);

    //     //Takes Max value of the choices
    //     return dp[idx][capacity] = Math.max(choose, notChoose);

    // }

    // private static int helperRecursion(int[] weight, int[] value, int idx, int capacity) {

    //     //base case
    //     //If only one item, then check with the capacity
    //     if (idx == 0) {
    //         if(weight[0] <= capacity) {
    //             return value[0];
    //         }else {
    //             return 0;
    //         }
    //     }

    //     //choose
    //     //current value of the included weight + recursive solution of the remaining weights    
    //     int choose = 0;
    //     if (weight[idx] <= capacity) {
    //         choose = value[idx] + helperRecursion(weight, value, idx -1, capacity - weight[idx]);
    //     }

    //     //Not choose
    //     //current index not included then 0 value + + recursive solution of the remaining weights 
    //     int notChoose = 0 + helperRecursion(weight, value, idx-1, capacity);

    //     //Takes Max value of the choices
    //     int ans = Math.max(choose, notChoose);

    //     return ans;

    // }


    public static void main(String [] args) {

        int profit[] = new int[] { 60, 100, 120 }; 
        int weight[] = new int[] { 10, 20, 30 }; 
        int capacity = 50; 
        int n = profit.length; 
        System.out.println(knapsack(weight, profit, n, capacity)); 
    }
}
