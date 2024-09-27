
public class Knapsack_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Max value--");
		int [] values = new int[] {60,100,120,200};
		int [] weights = new int[] {10,20,30,20};
		int capacity = 50;
		System.out.println(maxKnapsack(values,weights, capacity));
	}
	
	//Approach:1. Here I have taken dp approach, with weights in the row and capacity in the column, 
	//2. if target capacity is less than weights, we take previous dp value not considering the new weight
	//3. or else we add the corresponding value of the weight to the target-weights(i-1) and compare it with the old value which ever is maximum, we will take that.
	//4. Finally, we return the last element of the dp matrix
	public static int maxKnapsack(int[] values, int[] weights, int capacity)
	{
		int[][] dp = new int[weights.length+1][capacity+1];
		
		for(int i=0;i<= weights.length;i++)
		{
			dp[i][0] = 0;
		}
		for(int i=0;i<= capacity;i++)
		{
			dp[0][i] = 0;
		}
		for(int i=1;i<= weights.length;i++)
		{
			for(int j=1;j<= capacity;j++)
			{
				//case-1:
				if(j < weights[i-1])
					dp[i][j] = dp[i-1][j];
				else
				{
					dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j-weights[i-1]]);
				}
			}
		}
	/*	for(int i=0;i<=weights.length;i++)
		{
			for(int j=0;j<=capacity;j++)
			{
				System.out.print("--"+dp[i][j]+"--");
			}
			System.out.println("");
		} */
		return dp[weights.length][capacity];
	}

}
//Time Complexity : O(n * c) where n - length of the weights array and c - capacity of knapsack
//Space Complexity : O(n*c) where n - length of the weights array and c - capacity of knapsack
//Did this code successfully run on Leetcode : 
//Any problem you faced while coding this :

