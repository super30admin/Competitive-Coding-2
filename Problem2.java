// Time Complexity :O(weights*capacity)
// Space Complexity :O(weights*capacity)
public class Main {
    public static void main(String[] args) {
        int weights[]=new int[]{10,20,30};
        int values[]=new int[]{60,100,120};
        int capacity=50;
        int m=weights.length;
        int n=capacity;
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<m;i++) dp[i][0]=0;
        for(int i=0;i<n;i++) dp[0][i]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(weights[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],values[i-1]+dp[i-1][j-(weights[i-1])]);
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
       System.out.println(dp[m][n]);
    }
}