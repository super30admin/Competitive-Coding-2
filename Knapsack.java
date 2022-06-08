//space complexity:o(1)+o(n)
//time complexity: o(2^n)
import java.util.*;
import java.lang.*;
class Knapsack{
    
  
    
static int knapSack(int W, int wt[], int val[], int n)
{

    if(n == 0 || W == 0)
        return 0;
    
    if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
    
    int case1 = val[n-1]+knapSack(W-wt[n-1],wt,val,n-1);
    
    int case2= knapSack(W,wt,val,n-1);
    
    return Math.max(case1,case2);
    
  
}
public static void main(String[] args)
{
	int val[] = { 60, 100, 120 };
	int wt[] = { 10, 20, 30 };
	int W = 50;
	int n = val.length;
	System.out.print(knapSack(W, wt, val, n));
}
}