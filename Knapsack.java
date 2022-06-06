//time complexity: O(N*W) 
//space complexity: O(N*W) 

// "static void main" must be defined in a public class.
public class Knapsack {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int idx = val.length;
        System.out.println(bag( W, weight, val, idx));
    }
     static int bag(int W, int weight[], int val[], int idx) 
    { 
         //basic checks
         if(W == 0 || weight.length == 0)   return 0;
         
        //create a table matrix to fill the values 
        int[][] dp = new int[idx+1][W+1];
    
         //iterate through table rows
     for(int i = 0; i < dp.length; i++){
         //iterate through table columns
         for(int j = 0; j< dp[0].length; j++){
             
             // checking the base conditions and put 0 values in dummy rows and columns
             if(i == 0 || j == 0 ){
                 dp[i][j] = 0;
             }
             else if(j < weight[i-1]){
                   //assign the previous value 
                 dp[i][j] = dp[i-1][j];
             }else{
                  //this returns the maximum value of the array
                 dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i-1]] + val[i-1]);
         }
    } 
}
    return dp[idx][W];
}
}


