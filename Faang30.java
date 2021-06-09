// Time complexity = O(M*N)
// Space complexity= O(M*N)


package leetcode;

public class Faang30 {
    public int maxValue(int[] value,int[] weight, int maxWeight){
        if(value.length==weight.length && value.length==0) return -1;

        int[][] dp = new int[weight.length+1][maxWeight+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j < weight[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{ //maximum between value from top row and sum values between value of current column and value of column that is difference of the weight of  current column.
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-(weight[i-1])]+value[i-1]);
                }
            }
        }
        for(int i=1; i<dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[] value={60,100,120,180};
        int[] weight={10,20,30,40};
        int maxWeight=100;
        Faang30 obj=new Faang30();
        System.out.println(obj.maxValue(value,weight,maxWeight));
    }
}

