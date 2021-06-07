package CompetitiveCoding2;

public class KnapsackRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {60,100,120};
		int[] weights = {10,20,30};
		int cap = 50;
		
		int maxValue = knapsack(values,weights,cap);
		
		System.out.println(maxValue);
	}

	private static int knapsack(int[] values, int[] weights, int cap) {
		// TODO Auto-generated method stub
		int n = weights.length;
		int i=0;
		int maxValue=0;
		return helper(values,weights,cap,i,n,maxValue);
	}

	private static int helper(int[] values, int[] weights, int rem_cap, int i, int n, int maxValue) {
		// TODO Auto-generated method stub
		
		//base
		if(i >= n || rem_cap ==0) return maxValue;
		
		
		//logic
		if(weights[i] > rem_cap) {
			return helper(values,weights,rem_cap,i+1,n,maxValue);
		}
		//choose
		int case1 = helper(values,weights,rem_cap-weights[i],i+1,n,maxValue+values[i]);
		
		//not choose
		int case2 = helper(values,weights,rem_cap,i+1,n,maxValue);
		
		return Math.max(case1, case2);
	}
	

}
