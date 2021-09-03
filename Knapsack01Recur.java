package interviews;

public class Knapsack01Recur {
	
	public int helper(int profit,int rem_capacity,int[] wt,int[] val,int i,int n) {
		//base case
		if(i>=n || rem_capacity==0 )
		return profit;
		
		
		
		//logic
		if(wt[i]>rem_capacity) {
			return helper(profit,rem_capacity,wt,val,i+1,n);
		}
		//choose
		int choose=helper(profit+val[i],rem_capacity-wt[i],wt,val,i+1,n);
		
		
		//not choose
		int notchoose=helper(profit,rem_capacity,wt,val,i+1,n);
		
		return Math.max(choose, notchoose);
	}
	public int kanpsack(int[] wt,int[] val,int capacity,int n) {
		
		
		return helper(0,capacity,wt,val,0,n);
	}

}
