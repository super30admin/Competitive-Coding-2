//time Complexity :  O(N*W)  -- travesing throwing the Knapsack array
//Space Complexity:  O(N*W)  -- fill  throwing the Knapsack array

class Solution {
    public int knapsack(int[] coins, int amount) {
    
       
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
        else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), 
                         knapSack(W, wt, val, n-1) 
                          );      
    }
}
