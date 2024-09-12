//Time complexity: O(mn) m->Capacity n->items
//Space compelxity: O(mn)

Class Solution{
    public class knapsack(int[] weight,int[] values,int capacity){
        int n=weight.length;
        int[][] dp=new int[n+1][capacity+1];
        for(i=0;i<n+1;i++){
            for(j=0;j<weight+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(j>=weight[i-1]){
                    dp[i][j]=Math.max(values[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}