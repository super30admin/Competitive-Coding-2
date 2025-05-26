/***
 * Did this code successfully run on GeeksForGeeks :  Yes
Any problem you faced while coding this :  No

Approach 1 - Exhaustive search  -  Time Complexity : 2^n , Space Complexity :O(n)

Approach 2 - Top Down - Time Complexity : O(n*W), Space Complexity : O(n*W)

 Approach 3- Bottom Up - Still need to implement, struggled to understand the relation between n and wt and value in tabulation
 ***/
public class KnapSackProblemTLE {
    //Time Complexity : 2^n
    //Space Complexity :O(n)
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int result = helper(W, val,wt, 0);
        if(result == Integer.MIN_VALUE) return -1;
        return result;
    }
    private static int helper(int W, int val[], int wt[], int index) {
        //Base Case
        if(W < 0) return Integer.MIN_VALUE; //not a vlaid path in the exhaustuve tree
        if(W == 0 || index == val.length ) return 0;

        //logic
        //choose
        int choose = 0;
        //pick the item if it does not exceed the capacity
        if(wt[index] <= W ){
            choose = val[index] + helper(W - wt[index], val, wt, index+1);
        }
        int notChoose = helper(W, val, wt, index+1);

        return Math.max(choose, notChoose);
    }

}
//Top Down
//Time Complexity : O(n*W)
//Space Complexity : O(n*W)
class KnapSackProblemTopDown {
    static int[][] memo;
    static int knapsack(int W, int val[], int wt[]) {
        int len = val.length;
        memo = new int[len+1][W+1];
        for(int i = 0; i<=len; i++){
            for(int j = 0; j<=W; j++){
                memo[i][j] = -1;
            }
        }
        return helper(W, val, wt,0);

    }
    private static int helper(int W, int val[], int wt[], int index){
        //base case
        if(index == val.length || W == 0) return 0;
        if(memo[index][W]!= -1)
            return memo[index][W];

        int choose = 0;
        if(wt[index] <= W ){
            choose = val[index] + helper(W - wt[index], val, wt, index+1);
        }
        int notChoose = helper(W, val, wt, index+1);
        memo[index][W] = Math.max(choose, notChoose);
        return memo[index][W];
    }
}

