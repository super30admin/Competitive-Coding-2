/*
 *  Time Complexity: O(N*M) where N is the number of weights and M is the maxWeigth.
 *  Space Complexity: O(N*M) where N is the number of weights and M is the maxWeigth. Since we create a dp array of N*M size.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : Design the approach to hold the min element.
 *
 *  Explanation: Create a dp array of size N*M where N is the number of weights and M is the maxWeigth.. Each cell in this dp array holds the max possible value for that particular cell. Each cell can be calculated by finding the max possbile value when the current weight is considere and not considered. The value when the current weight is not considered can be fetched from dp[i-1][j] and the value when considering the current weight can be computed by adding values[i-1] + dp[i-1][j-weight[i-1]]. Once we compute the values of all the cell we can simply return the value in the last cell.*/
public class HelloWorld{
     public static void main(String []args){
        System.out.println("Hello World");
        int[] weights=new int[]{1,2,3};
        int[] values=new int[]{60,100,120};
        int result = maxTargetValues(weights, values, 5);
        System.out.println("result: "+result);
     }
     public static int maxTargetValues(int weights[], int values[], int maxWeight){
         if(weights==null || weights.length==0 || weights.length!=values.length) return 0;
        // Arrays.sort(weights);
        int[][] dp = new int[weights.length+1][maxWeight+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<weights[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], values[i-1]+dp[i-1][j-weights[i-1]]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
     }
}


