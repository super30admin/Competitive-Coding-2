import java.util.*;

//Time Complexity : O(c*w) c = capacity and w = total number of weights
//Space Complexity : O(c*w)
//Did this code successfully run on Leetcode : N/A
//Any problem you faced while coding this : No

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int value[] = {60,100,120};
        int weights[] = {10,20,30};
        int capacity = 50;

        int dp[][] = new int[weights.length + 1][capacity+1];

        for(int i = 1;i <= weights.length; i++){
            for(int j = 1;j <= capacity; j++){
                if(weights[i-1] > j){
                    //if the current weight exceeds the capacity then simply reuse the previous entry
                    dp[i][j] = dp[i-1][j];
                }else{
                    //if weight is less than or equal to the capacity then choose maximum of the previous row, same capacity and previous row and the subdifference weight with the added current value of that particular weight
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]] + value[i-1]);
                }
            }
        }

        //maximum profit would be obtained in the end of the matrix
        System.out.println("Max Profit: "+dp[weights.length][capacity]);
    }
}
