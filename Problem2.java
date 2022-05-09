//Time Complexity : O(W*val)
//Space Complexity : O(W*val)
public class Problem2 {
    public static int Total(int[] weights, int[] val, int W,int index){
    if(val==null || val.length==0 || weights==null || weights.length==0 || W ==0) return 0;
    int[][] dp = new int[weights.length+1][W+1];
    for(int i=0;i<=weights.length;i++){
        for(int j=0; j<=W ; j++){
            if(i==0 || j==0) {
                dp[i][j]=0;
            }
            //i=1;j=1 the weight
            else if(j >= weights[i-1]){
                dp[i][j]=Math.max(val[i-1]+dp[i-1][j-weights[i-1]],dp[i-1][j]);
            }
            else{
                dp[i][j]=dp[i-1][j];
            }
        }
    }
    return dp[index][W];
    }
public static void main(String[] args) {
   int[] weights = new int[] {10,20,30};
    int[] values = new int[] {60,100,120};
    int w= 50;
    int index = weights.length;
    int result = Total(weights,values,w,index);
    System.out.println(result);
}
}