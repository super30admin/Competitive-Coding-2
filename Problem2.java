public class Problem2 {
	
	public static int maximum(int[] value, int[] weight, int maxWeight) {
	
		int w = weight.length;
		int[][] dp = new int[w+1][maxWeight+1];
		
		for(int i=0;i<dp.length;i++) {
		    dp[i][0]=0;
		}
		for(int j=0;j<dp[0].length;j++) {
			dp[0][j]=0;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(weight[i-1]<=j) {
				dp[i][j]= Math.max(dp[i-1][j], value[i-1]+ dp[i-1][j-weight[i-1]]);
				}else {
					dp[i][j]= dp[i-1][w];
				}
			}
		}
		
		
		
		
		
		
		return dp[w][maxWeight];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value[] = {60,100,120};
		int weight[]= {10,20,30};
		int maxWeight = 50;
		
		System.out.println(maximum(value,weight, maxWeight));
		

	}

}