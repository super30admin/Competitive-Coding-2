/**

TC - O(N*W) N is the length of values/weight array.
SC - O(N*W) auxilary space.


**/
class Practice {
    
    static int dp[][] ;
    
    public static int getMaxWeight(int values[], int weight[], int W, int index)
    {   
        // base condition
        if (values.length == 0 || weight.length == 0 || W <=0 || index == weight.length)
        {
            return 0;
        }
        
        if (dp[index][W] != -1)
        {
            return dp[index][W];
        }
        
        if (weight[index] > W)
        {
            return dp[index][W] = getMaxWeight(values, weight, W, index + 1);
        }

            // choose this index
        int maximumValueBySelecting = values[index] + getMaxWeight(values, weight, W-weight[index], index + 1);
        
        int maximumValueByNotSelecting = getMaxWeight(values, weight, W, index + 1);
        
        return dp[index][W] = Math.max(maximumValueBySelecting, maximumValueByNotSelecting);        
    }
    
    public static void main(String args[])
    {
        int values[] = new int[]{60,100,120};
        int weight[] = new int[]{10,20,30};
        int W = 50;
        dp = new int[values.length][W+1];
        
        for (int i=0; i<values.length; i++)
        {
            for (int j=0; j<=W; j++)
            {
                dp[i][j] = -1;
            }
        }
        
        System.out.println(getMaxWeight(values, weight, W, 0));
    }
}