// Time Complexity : O(weight*capacity)
// Space Complexity : O(weight*capacity)


/*  Recursive Logic
    if(capacity==0 || index==weight.length || weight[index]>capacity)
        return totalValue;


     //logic
     
     int case1= knapsack(weight,value,index+1,capacity-weight[index],totalValue+value[index]);

     int case2= knapsack(weight,value,index+1,capacity,totalValue);
     
     
     return Math.max(case1,case2); 

*/

public class Knapsack {
    
    public static int knapsack(int[] val,int[] weight, int capacity)
    {
        int[][] dp=new int[weight.length+1][capacity+1];
        
       
        for(int i=1;i<=weight.length;i++)
        {
            for(int j=1;j<=capacity;j++)
            {
                if(weight[i-1]>j)
                dp[i][j]=dp[i-1][j];
                else 
                    dp[i][j]= Math.max(
                        dp[i-1][j] , dp[i-1][j-weight[i-1]] + val[i-1] );
                
            }
        
       
    }
    return dp[weight.length][capacity];
    }

    public static void main(String[] args)
    {
        int[] val={60,100,120};
        int[] weight={10,20,30};

        int capacity=50;
      System.out.println(knapsack(val, weight, capacity));
    }

}
