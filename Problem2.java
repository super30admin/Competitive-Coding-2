//Recursive solution to the problem.
class Knapsack 
{ 
 
	static int knapSack(int W, int wt[], int val[], int n) {
		// If length is zero or target Weight is zero the return 0
		if(n == 0 || W == 0) {
			return 0;
		}
		// If the last element of the weights array is greater than the target weight, then we do not select that Weight
		if(wt[n-1]>W) {
			return knapSack(W,wt,val,n-1);
		}
		// Else we select the maximum weight out of the tow condition, whether including it or not including it.
		else {
			return Math.max(val[n-1] + knapSack(W - wt[n-1], wt, val, n - 1) , knapSack(W, wt, val, n-1)); 
		}
	}

public static void main(String args[]) 
{ 
	int val[] = new int[]{60, 100, 120}; 
	int wt[] = new int[]{10, 20, 30}; 
	int W = 50; 
	int n = val.length; 
	System.out.println(knapSack(W, wt, val,n)); 
	} 
} 

