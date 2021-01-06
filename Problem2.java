//Problem : 30 - knapsack
//TC : O(n*m), n means rows and m means columns of given input  
//SC : O(n*m), because I'm creating auxillary 2d array dp

//Initialise DP array with 0 and then similar to coin change , just make sure, here we have to add profit and we can take each element only once so modify the dp equation accordingly (means instead of choosing i the same element again and again replace it with 'i-1' if u are chosing that item)

class Solution30{

    public static void main(String []args){
       System.out.println("Hello World");
       
        int val[] = { 60, 100, 120 }; 
        int wt[] = { 10, 20, 30 }; 
        int W = 50;
        
        /*int val[] = { 10, 15, 40 };
        int wt[] =  { 1,2,3 }; 
        int W = 6;*/
        
       //Bottom Up DP 
       System.out.println("Max Profit is "+dpMaxProfit(wt,val,W));
       
       //Brute Force
       //System.out.println("Max Profit is "+calcMax(wt,val,wt.length-1,W));
    }
    

    //Bottom Up DP
    private static int dpMaxProfit(int[] wt, int[] profit,int threshold){
  
        if(wt==null || wt.length==0 || profit==null || profit.length==0){
           return 0;
        }
        
        int[][] dp = new int[wt.length+1][threshold+1];
        
        for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[0].length;j++){
               
               if(j>=wt[i-1]){
                  dp[i][j] = Math.max(profit[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
               }else{
                  dp[i][j] = dp[i-1][j];
               }
               
           }
        }
        
        
        return dp[wt.length][threshold];
  }
    
    //Brute Force Recursion
    /*private static int calcMax(int[] wt, int val[], int n, int threshold){
        
        //base
        if(n<0){
            return 0;
        }
        
        if(threshold<=0){
            return 0;
        }
        
        //logic
        if(threshold>=wt[n]){//choose
            return Math.max(val[n]+calcMax(wt,val,n-1,threshold-wt[n]), calcMax(wt,val,n-1,threshold));
        }else{//not choose
            return calcMax(wt,val,n-1,threshold);
        }
        
        
    }*/
    
    
}