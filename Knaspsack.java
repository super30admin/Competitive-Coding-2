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
                    dp[i][j] = 0;
                }else if(j< wieghts[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wieghts[i-1]]+values[i-1]);
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
    
}
