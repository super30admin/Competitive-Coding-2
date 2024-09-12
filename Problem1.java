// When supply of weight is finite
class Mock2{
    public static int knapSack(int[] wt,int[] profit,int target){
            int[][] dp = new int[wt.length+1][target+1];

            dp[0][1] = profit[0];

            for(int i=1;i<wt.length+1;i++){
                for(int j=0;j<target+1;j++){
                    if(j<wt[i-1]){
                        dp[i][j] = dp[i-1][j];
                    }else{

                        dp[i][j] = Math.max(dp[i-1][j],profit[i-1]+dp[i-1][j-wt[i-1]]);

                    }
                }
            }

            return dp[wt.length][target];
    }

    public static void main(String[] args){
        int profit[] = new int[] { 130, 150, 100, 190 };
		int weight[] = new int[] { 10, 20, 30,40 };
		int maxWeight = 50;
		int n = profit.length;
		System.out.println(knapSack(weight, profit,maxWeight));
    }
}