// Time Complexity : The time complexity is O(n*w) where n is the length of the array and w is the weight
// Space Complexity : The spave complexity is O(n*w) where n is the length of the array and w is the weight
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Main {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;

        int[][] dp = new int[n+1][W+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<=n;i++){

            for(int j=1;j<=W;j++){

                // Fill with the maximum of taking and not taking that particular weigth
                if(j >= wt[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
                }
                // Keep the previous values
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][W]);
    }
}


// Time Complexity : The time complexity is O(2^n) where n is the length of the array since we either choose or not choose the number.
// Space Complexity : The spave complexity is O(n) where n is the length of the array since we have an internal stack for recursive calls.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Main {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        System.out.println(knapSack(wt,val,W,0,0));
    }

    public static int knapSack(int[] wt,int[] val,int W,int sum,int index){

        if(W < 0){
            return -1;
        }

        if(index == wt.length){
            return sum;
        }

        // Choose the current number
        int case1 = knapSack(wt,val,W-wt[index],sum+val[index],index+1);
        // Dont choose the current number
        int case2 = knapSack(wt,val,W,sum,index+1);

        if(case1 == -1){
            return case2;
        }

        if(case2 == -1){
            return case1;
        }

        // return the maximum of both the cases
        return Math.max(case1,case2);

    }
}