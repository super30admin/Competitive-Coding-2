// TC - O(m X n), SC - O(m X n) --> m is weights.length + 1 and n is capacity + 1

public class KnapsackProblem01 {
	public static void main(String[] args) {
		// weights array and values array
		int[] w = {1, 2, 3};
		int[] v = {10, 15, 40};
		// capacity of bag
		int capacity = 5;
		
		// We are developing m X n matrix where m is w.length + 1 and n is capacity + 1
		int m = w.length+1;
		int n = capacity + 1;
		int[][] dp = new int[m][n];
		// Iterate through m and n, if i-1th index of w[] is greater than j(which is capacity), copy above row data, i.e without the current weight and with all the previous weights for that particular capacity, 
		// which can be found i-1th row and jth column in matrix, else now we need to calculate Choose current weight or Don't choose current weight options, if we choose, calculate i-1th index of v plus value
		// from dp matrix for row, weigths without current weight and for column, current capacity - weight what we have choose and for Dont choose option, value without current weight
		for(int i=1; i<m; i++) {
			for(int j=1; j<n ;j++) {
				if(w[i - 1] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(v[i-1] + dp[i-1][j - w[i-1]], dp[i-1][j]);
				}
			}
		}
		// return last row, last column value of dp array
		System.out.println(dp[m-1][n-1]);
	}
}
