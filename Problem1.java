// 0/1 Knapsack problem
//Time complexity:O(mn) where m is the length of weights and n is the capcity
//space Complexity:O(mn)
public class Problem1{
    public int zero_One_Knapsack(int values[],int capacity,int weights[]){
        if(weights.length==0|| weights==null){
            return 0;
        }
        int dp[][]=new int [weights.length+1][capacity+1];
        for(int i=0;i<capacity+1;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<weights.length+1;i++){
            for(int j=0;j<capacity+1;j++){
                if(j<weights[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],values[i-1]+dp[i-1][j-weights[i-1]]);
                }
            }
        }
        return dp[values.length][capacity];
    }
   
    public static void main(String args[]){
        int values[]={1,2,6};
        int weights[]={2,3,5};
        int capacity=8;
        Problem1 obj=new Problem1();
        System.out.println(obj.zero_One_Knapsack(values, capacity, weights));
    }
}