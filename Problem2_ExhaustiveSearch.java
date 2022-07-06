//Time Complexity : O(2^n)
//Space Complexity : O(n)
// Solution accepted but Time Limit Exceeded due to Exhaustive Search.


public class ExhaustiveSearch{
	
	public static int knapSack(int W, int wt[], int val[], int n) {
		
		if (n == 0)
			return -1;
		
		return helper(W, wt, val,0, 0, n);
		
	}
	
	private static int helper(int W, int wt[], int[] val,int index, int amount, int n) {
		
		if(W <0 || index == n +1)
			return -1;
		
		else if( W ==0 || index == n)
			return amount;
		
		// do not choose the current item
		int case1 = helper(W, wt, val, index +1, amount, n);
		
		//choose the current item
		int case2 = helper(W - wt[index], wt, val, index +1, amount + val[index], n);
		
		return Math.max(case1, case2);
		
	}


	public static void main(String[] args) {
		int[] wt = new int[] {4,5,1};
		int[] val = new int[] {1,2,3};
		int W =5;
		int n =3;
		
		int ans = ExhaustiveSearch.knapSack(W, wt, val, n);
		System.out.println(ans);
	}
}