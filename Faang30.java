// Time complexity = O(M*N)
// Space complexity= O(M*N)


package leetcode;

public class Faang30 {
    public int maxValue(int[] value,int[] weight, int maxWeight){
        if(value.length==weight.length && value.length==0) return -1;
        int column = maxWeight/10+1;
        int sumWeight = 0;
        int[][] dp = new int[weight.length+1][column];

        for(int i=1;i<dp.length;i++){
            sumWeight += weight[i-1];//sym if weights for each column.
            for(int j=1;j<column;j++){
                // value greater than the sums of the weights is zero.
                if(j*10>sumWeight) break;
                //value from top row
                if(j*10 < weight[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{ //maximum between value from top row and sum values between value of current column and value of column that is difference of the weight of  current column.
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-(weight[i-1]/10)]+value[i-1]);
                }
            }
        }
    return dp[dp.length-1][column-1];
    }

    public static void main(String[] args) {
        int[] value={60,100,120,180};
        int[] weight={10,20,30,40};
        int maxWeight=100;
        Faang30 obj=new Faang30();
        System.out.println(obj.maxValue(value,weight,maxWeight));
    }
}
