package CompetitiveCoding2;

public class KnapSack {
    public static int maxWeight(int[] w, int[] v, int target){

    int[][] dp = new int[w.length + 1][target+1];

    for(int i= 1;i<dp.length;i++){
        for(int j=1;j<dp[0].length;j++){
            if( j < w[i-1]){
                dp[i][j] = dp[i-1][j];
            }else{
                dp[i][j] = Math.max(dp[i-1][j], v[i-1] + dp[i-1][j - w[i-1]]);
            }
        }
    }
    return dp[dp.length-1][dp[0].length-1];
}

    public static void main(String[] args) {
        System.out.println(maxWeight(new int[]{1,2,3}, new int[]{10, 15, 40}, 6));
    }

}
