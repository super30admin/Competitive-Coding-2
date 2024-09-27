// Time Complexity : O(n*capacity)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : NO
class Problem1{

        int knapSack(int W, int wt[], int val[])
        {

            //wt denotes the weight array
        // W is the capacity , which has to be less than or equal to W
        //val[] is the possible values for each weight

        //null check
        if(W== null || wt==null || val==null ||
         wt.length==0 || val.length==0 ) return 0;

        int n = wt.length;

        //creating a new 2d dp array
        //taking w+1 and n+1 to get a dummy row
        //dummy row denotes when we dont have any wt , but still have some capacity to make
        int[][] dp = new int[w+1][n+1];

        //filling the dummy row
        dp[0][0] =0;

        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i=2; i<wt.length; i++){
            for(int j=1; j<dp[0].length; j++ ){

                //when weight is greater than the capacity
                //we just get the values from one row above
                if(j>= W) {
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , wt[i+1]+ dp[i-1][j-wt[i-1]]);
                 }

            }

        }

        return dp[w][n];



        }
}