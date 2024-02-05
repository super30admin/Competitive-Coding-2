// Problem Name: Interview Problem: 0-1 Knapsack Problem
// Source Link: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

// Time Complexity : Optimized DP - O(MN), where M is the length of weights array, and N is the weight limit
// Space Complexity : Optimized DP - O(N), where N is the weight limit
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Problem2{

    //1. Recursive exhaustive approach
    private static int knapsack(int[] wt, int[] p, int limit, int idx, int profitTillNow){
        //base
        if(limit<0) return 0;
        if(idx==wt.length)    return profitTillNow;

        //logic
        // Case1. Don't choose current item
        int case1 = knapsack(wt,p,limit, idx+1,profitTillNow);

        // Case2. Choose current item
        int case2 = knapsack(wt,p,limit-wt[idx], idx+1, profitTillNow+p[idx]);

        return Math.max(case1, case2);
    }

    //2. Bottom-up dp of above exhaustive recursive approach
    private static int dp(int wt[], int[] p, int limit){
        int m=wt.length;
        int n=limit;

        int[][] storage=new int[m+1][n+1];

        //Base case-- when no input elements, max profit will always be zero
        //So first row will entirely be zero, storage[0][]
        
        // Build up for the rest of the cases
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<wt[i-1]){
                    // Not choose case
                    storage[i][j]=storage[i-1][j];
                }else{
                    // Case1. do not choose weight at ith index
                    int case1=storage[i-1][j];

                    //Case2. choose weight at ith index and add up the profit
                    int case2=p[i-1] + storage[i-1][j-wt[i-1]];

                    // Take max profit
                    storage[i][j]=Math.max(case1, case2);
                }
            }
        }

        return storage[m][n];
    }

    //3. Space optimized dp
    private static int optimizedDp(int wt[], int[] p, int limit){
        // From the dp solution we can see that, at any point in calculation
        // of storage[i][j], we are using storage[i-1][j] and storage[i-1][j-wt[i-1]].
        // We can only store the i-1 and ith rows 

        int m=wt.length;
        int n=limit;

        int[][] storage=new int[2][n+1];

        //Base case-- when no input elements, max profit will always be zero
        //So first row will entirely be zero, storage[0][]
        
        // Build up for the rest of the cases
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<wt[i-1]){
                    // Not choose case
                    storage[1][j]=storage[0][j];
                }else{
                    // Case1. do not choose weight at ith index
                    int case1=storage[0][j];

                    //Case2. choose weight at ith index and add up the profit
                    int case2=p[i-1] + storage[0][j-wt[i-1]];

                    // Take max profit
                    storage[1][j]=Math.max(case1, case2);
                }
            }

            // Move current row(1) to prev row(0),
            // and reset the curr row
            storage[0]=storage[1];
            storage[1]=new int[n+1];
        }

        return storage[0][n];
    }


    public static void main(String[] args){
        int[] wt={1,2,3};
        int[] p={10,15,40};
        int limit=6;
        
        //1. Recursive exhaustive approach
        System.out.println("Exhaustive Approach: "+knapsack(wt,p,limit,0,0));

        //2. DP approach
        System.out.println("DP Approach: "+dp(wt,p,limit));

        //3. Space optimized DP approach
        System.out.println("Optimized DP Approach: "+optimizedDp(wt,p,limit));
    }
}