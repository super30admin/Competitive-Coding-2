import java.lang.Math;

//Time complexity: O(n^2) -> n(items)XW(target weight)
//Space complexity: O(n^2) -> n(items)XW(target weight)

class Knapsack 
{            
	    static int knapSack(int W, int wt[], int val[], int n) 
	    { 
	         int i, w; 
	         int K[][] = new int[n+1][W+1]; 
	       
	     // Build table K[][] in bottom up manner 
	     for (i = 0; i <= n; i++) 
	     { 
	         for (w = 0; w <= W; w++) 
	         { 
	             if (i==0 || w==0) //row 0(no items to pick) and column 0(Wt :0) will have all entries 0 - base case
	                  K[i][w] = 0; 
	             else if (wt[i-1] <= w) //max of current item's value and previously calculated max value
	                   K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]); 
	             else
	                   K[i][w] = K[i-1][w]; 
	         } 
	      } 
	       
	      return K[n][W]; 
	    } 

    
    public static void main(String args[]) 
    { 
        int val[] = new int[]{60, 100, 120}; 
    int wt[] = new int[]{10, 20, 30}; 
    int  W = 50; 
    int n = val.length; 
    System.out.println(knapSack(W, wt, val, n)); 
    } 
} 
