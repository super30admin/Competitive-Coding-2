//time-complexity-O(m*n)
// space-complexity-O(m*n)


// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        int[] weights=new int[]{10,20,30};
        int capacity=50;
        int[] values=new int[]{60,100,120};
        int res= helper(values,weights,capacity);
         System.out.println("max profit"+res);
    }
    
    public static int helper(int[] values,int[] weights,int capacity){
         int m=weights.length;
        int n=capacity;
        int[][] dp=new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
           for(int j=1;j<=n;j++){
               if(j < weights[i-1]){
                   dp[i][j] = dp[i-1][j];
               }else{
                    dp[i][j] = Math.max(dp[i-1][j],values[i-1]+dp[i-1][j-weights[i-1]]);
               }
           }
        }
       return dp[m][n];
    }
}