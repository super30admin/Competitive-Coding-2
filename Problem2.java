//Time Complexity :O(2^n)
// Space Complexity : O(n*m)

/*************************** Recursive Approach**************************/

public class Problem2 { 
	
	public static int knapSack(int[] weight, int[] value, int capacity) {
		return helper(weight, value, capacity, 0, capacity, 0);
	}
	
    private static int helper(int[] weight, int[] value, int capacity, int index, int curr_cap, int curr_val)
    {
      if(index >=weight.length || curr_cap==0)
        return curr_val;
      
      if(curr_cap - weight[index] < 0)
    	  return helper(weight, value, capacity, index+1, curr_cap, curr_val);
      
      // case1 : do not choose weight
      int case1 = helper(weight, value, capacity, index+1, curr_cap, curr_val);
      
      // case2 : choose weight
      int case2 = helper(weight, value, capacity, index+1, curr_cap - weight[index], curr_val + value[index]);

      return Math.max(case1,case2);

    }

    public static void main(String args[]) 
     { 
         int value[] = new int[] { 60, 100, 120 }; 
         int weight[] = new int[] { 10, 20, 30 }; 
         int capacity = 50; 
         System.out.println(knapSack(weight, value, capacity)); 
     } 

 }


/*************************** DP Approach**************************/
/*
 * Time Complexity :O(n*m); n: length of the array , m: max weight
 * Space Complexity : O(n*m)
 * 
 */
public class Problem2{
    public static int knapSack(int[] weights, int[] values, int capacity){
     
        int row = capacity + 1;
        int column = weights.length + 1;
        
        int[][] dp = new int[column][row];
        
        for(int i=1; i<column; i++){
            dp[i][0] = 0;
        }
        for(int i=1; i< column; i++){
            for(int j=1; j<row; j++){
                if(weights[i-1] <= j)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]] + values[i-1]);
                
                else
                	dp[i][j] = dp[i-1][j];
            }
        }
        return dp[column-1][row-1];
    }
    
    public static void main(String args[]) 
    { 
        int value[] = new int[] { 60, 100, 120 }; 
        int weight[] = new int[] { 10, 20, 30 }; 
        int capacity = 50; 
        System.out.println(knapSack(weight, value, capacity)); 
    } 
} 