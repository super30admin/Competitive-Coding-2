// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes, in compilers


// Your code here along with comments explaining your approach

class Problem1{
    public static int knapSack(int[] weights, int[] values, int capacity)
    {
        
        int[][] dp = new int[weights.length+1][capacity+1];
        for(int i=1;i< weights.length+1;i++)
        {
            for(int j=1;j<capacity+1;j++)
            {
                if(j<weights[i-1])
                {
                    dp[i][j]= dp[i-1][j];   // 0 case maximum value can be the value from previous weights
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+values[i-1]); 
                     // take max between when element is not included and element included+ remaining capacity with remaining weights
                }
            }
        }
        return dp[weights.length][capacity];
    }

    public static void main(String[] args)
    {
        int[] values = new int[]{10,20,30};
        int[] weights= new int[]{1,2,3};
        int capacity = 5;

        System.out.println("The Maximum value we can get is :"+ knapSack(weights,values, capacity));
    }
}