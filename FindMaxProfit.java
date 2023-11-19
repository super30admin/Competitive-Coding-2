// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
public class FindMaxProfit {

	public static int findMax(int[] items, int[] profit, int totalCapacity)
	{
		return helper(items, profit, totalCapacity, 0, 0, 0);
		
	}
	
	public static int helper(int[] items, int[] profit, int totalCapacity, int capacity, int i, int totalProfit) 
	{
		
		if(i >= items.length || capacity > totalCapacity) return totalProfit;
		
		//not choose
		int case0 = helper(items, profit, totalCapacity, capacity, i+1, totalProfit);
		
		//choose
		int case1 = 0;
		
		if(capacity+items[i] <= totalCapacity)
		case1 = helper(items, profit, totalCapacity, capacity+items[i], i+1, totalProfit+profit[i]);
		
		return Math.max(case0, case1);
	}
	public static void main(String args[])
	{
		int[] items = {10,20,30,40};
		int[] profit = {130,110,170,190};
		int capacity = 50;
	
		System.out.println(findMax(items, profit, capacity));
	}
}
