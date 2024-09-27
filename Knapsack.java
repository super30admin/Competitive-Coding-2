
import java.util.*;
public class HelloWorld{
    public static int solveKnapSack(int weights[],int profits[],int capacity){
        if(capacity == 0 || weights == null || profits == null ||weights.length!=profits.length)
        return 0;
        int dp[][] = new int[profits.length][capacity+1];
        for(int i=0;i<capacity+1;i++){
            if(weights[0]<=i){
                dp[0][i] = profits[0];
            }
        }
        for(int i=1;i<profits.length;i++){
            for(int j=1;j<capacity+1;j++){
                if(weights[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], (profits[i]+dp[i-1][j-weights[i]]));
                }
            }
        }
        return dp[profits.length-1][capacity];
    }
     public static void main(String []args){
        System.out.println("Hello World");
        int profits[] = {1,2,6};
        int weights[] = {2,3,5};
        int capacity = 8;
        System.out.println(solveKnapSack(weights,profits,capacity));
     }
}