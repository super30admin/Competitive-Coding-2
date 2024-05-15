// Time O(capacity * n) where n is the number of elements presetn//
// Space O(capacity * n)
// Yes

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] val=new int[] {60, 100, 120};
        int[] wt=new int[] {10, 20, 30};
        int capacity=50;
        
        System.out.println(knapsack(val, wt, capacity));
    }
    
    private static int knapsack(int[] val, int[] wt, int capacity)
    {
        if(val==null || wt==null)
            return -1;
        
        int[][] dp=new int[val.length+1][capacity+1];
        
        for(int i=1;i<val.length+1;i++)
        {
            for(int j=1;j<capacity+1;j++)
            {
                if(j<wt[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                {
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }         
            }
        }
        
        return dp[val.length][capacity];
    }
}