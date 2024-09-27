/*
Desc:
Time Complexity: O(n^2) 
Space complexity: O(n^2)
*/
import java.lang.Math;
public class WeightsnValues{
    public static void main(String []args){
        // I have divided the wieghts and threshold capacity by 10 for coding easily. 
        int wieghts[] = {1,2,3};
        int values[] = {80,100,120};
        int threshold = 5;
        int dp[][] = new int[wieghts.length+1][threshold+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0; //creating buffer for supporting the algorithm ahead
                }else if(j< wieghts[i-1]){
                    dp[i][j] = dp[i-1][j]; //Zero case where we do not choose the current wieght, we use the value above it.
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wieghts[i-1]]+values[i-1]); //when we use the current wieght we check if the usage of the wieght would lead to maxium value or if the zero case itself is max and pick maximum of them.
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]); //returning the last element of the matrix would give the maximum value for the capacity given.
    }
    
}
