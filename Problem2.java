//KnapSack BruteForce SOlution
//Space Complexity is O(1)
//Time Compplexity is O(2^n)

package KnapSack;

public class KnapRecur {
	public static void main(String[] args) {
		int[] weight = { 10, 20, 30 };
		int[] value = { 60, 100, 120 };
		int totalWeight = 50;
		System.out.println(findKnapSack(weight, value, totalWeight, -1));
	}

	public static int findKnapSack(int[] weight, int[] value, int totalWeight, int length) {
		if (totalWeight == 0 || length == weight.length-1) {
			return 0;
		}
		//System.out.println(length);
		if (weight[length + 1] <= totalWeight) {
			return Math.max(value[length + 1] + findKnapSack(weight, value, totalWeight - weight[length + 1], length + 1),
					findKnapSack(weight, value, totalWeight, length + 1));
		} else {
			return findKnapSack(weight, value, totalWeight, length + 1);
		}
//		return 0;
	}

}
//KnapSack Memoization SOlution
//Space Complexity is O(m*n)
//Time Compplexity is O(n)

package KnapSack;

public class knapMemoization {
	static int[][] dp;
	public static void main(String[] args) {
		int[] weight = { 10, 20, 30 };
		int[] value = { 60, 100, 120 };

		int totalWeight = 50;
		dp=new int[value.length][totalWeight+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				dp[i][j]=-1;
			}
		}
		System.out.println(knapMemoization(weight, value, totalWeight, -1));
	}

	public static int knapMemoization(int[] weight, int[] value, int totalWeight, int length) {
		if (totalWeight == 0 || length == weight.length - 1) {
			return 0;
		}
		//System.out.println(length);
		if(dp[length + 1][totalWeight]==-1) {
			if (weight[length + 1] <= totalWeight) {
				dp[length + 1][totalWeight]= Math.max(
						value[length + 1] + knapMemoization(weight, value, totalWeight - weight[length + 1], length + 1),
						knapMemoization(weight, value, totalWeight, length + 1));
				return dp[length + 1][totalWeight];
			} else {
				dp[length + 1][totalWeight]= knapMemoization(weight, value, totalWeight, length + 1);
				return dp[length + 1][totalWeight];
			}
		}else {
			return dp[length+1][totalWeight];
		}
		
	}

}
//KnapSack Tabulation SOlution
//Space Complexity is O(m*n)
//Time Compplexity is O(n)

package KnapSack;

public class TabulationKnapSack {
	public static void main(String[] args) {
		int[] weight = { 10, 20, 30 };
		int[] value = { 60, 100, 120 };
		int totalWeight = 50;
		System.out.println(tabulKnapSack(value,weight,totalWeight));
	}
	
	public static int tabulKnapSack(int[] value,int[] weight,int totalWeight) {
		int[][] dp=new int[value.length+1][totalWeight+1];
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=0;
		}
		for(int j=0;j<dp[0].length;j++) {
			dp[0][j]=0;
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				if(weight[i-1]<=j) {
					dp[i][j]=Math.max(dp[i-1][j], value[i-1]+dp[i-1][j-weight[i-1]]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}

}
