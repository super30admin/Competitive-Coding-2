public class KnapSackSolution{

    public static void main(String []args){
       
       int[] weights={10,20,30};
       int capacity =50;
       
       int[] profits={100,200,300};
       
       
       
       System.out.println(knapSack(weights,profits,capacity));
    }
    
public static int knapSack(int[] weights, int [] profits, int capacity)
{
    int dp[][]= new int[weights.length+1][capacity+1];
    
    for(int i=1;i<=weights.length;i++)
    {
        for(int j=1;j<=capacity;j++)
        {
            
            if(j<weights[i-1])
            {
                dp[i][j]= dp[i-1][j];
                
            }
            else
            {
   dp[i][j]= Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+profits[i-1]);
            }
            
        }
    }
    return dp[weights.length][capacity];
    
}
}