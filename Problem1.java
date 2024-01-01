//Tried some test cases works proper
//Could have used 0 row but instead just handleled first row of matrix with if clause
// time should be O(mn) where mn is size of matrix

class Solution{
    public int kp(int[] w, int[] p,int c){
        int n = w.length;
        int[][] dp = new int[n][c+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){

                if(i==0){
                    if(w[i]>j){
                        dp[i][j] =0;
                    }
                    else{
                        dp[i][j] = p[i];
                    }

                }

                else{
                    if(w[i]>j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],p[i] + dp[i-1][j-w[i]]);
                    }
                    
                }
            }
        }






        return dp[n-1][c];
    }

}