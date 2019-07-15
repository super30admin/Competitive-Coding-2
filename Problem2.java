//time Complexity :  O(N*W)  -- travesing throwing the Knapsack array
//Space Complexity:  O(N*W)  -- fill  throwing the Knapsack array

class Solution {
    public int knapsack(int W, int[] wt, int[] val int n) {
    
       
        /*
         val = { 60,100,120}
         w = {10,20,30}
         W =50
        
         w -->   0  .  .  10  .      20  .   30 . . . .      50
         i  ---|---------------------------------------------------
         0  ---|-0--0---0--0--0--0-- 0    0-------------------0
        10  ---|-0--0---0--60--60--  60   60-- 60------60-----60
        20  ---|-0--0---0--60--60-- 100   160-- 160----160----160------
        30  ---|-0--0---0--60--60-- 100   160-- 160----160----220
            ---|---------------------------------------------------
                  
        */
        
        
        // Base Case 
        if (n == 0 || W == 0) 
            return 0; 

        // If weight of the nth item is more than Knapsack capacity W, then 
        // this item cannot be included in the optimal solution 
        if (wt[n-1] > W) 
           return knapSack(W, wt, val, n-1); 

        // Return the maximum of two cases:  
        // (1) nth item included  
        // (2) not included 
        else return Math.max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), 
                         knapSack(W, wt, val, n-1) 
                          );  
        
        
        
      //Dynamic Prog
      int n = wt.length;
      int k[][] = new int[n+1][W+1];
      //construct K array using the tabular form
      for (int i=0;i<= n ; i++)
      {
          for(int w=0;w<=W;w++)
          {
              if(n==0 || w ==0 )  k[i][w] = 0;  // initially at weight 0 , all the items will  0 we  will not include any weight to get value.
              
              else if(wt[i-1]<= W) 
                  k[i][w] = Math.max(k[i-1][w] , //previous value 
                                k[i-1][W-wt[i-1]] +val[i-1]);  // the value of current weight  + Total weight - sum of weights till now.
              else
                  k[i][w] = k[i-1][w] ;  //copy the previous value
            
          }
      }
        
        return k[n][W] ;
        
        
    }
}
