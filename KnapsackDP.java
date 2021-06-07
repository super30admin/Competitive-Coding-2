package CompetitiveCoding2;

public class KnapsackDP {

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
		int res[][] = new int[n+1][cap+1];
		
		for(int i =0; i<n+1;i++) {
			for(int j=0; j<cap+1;j++) {
				if(i == 0 || j== 0) {
					res[i][j] = 0;
				}else if(j <= weights[i-1]) {
					res[i][j] = res[i-1][j];
				}else {
					res[i][j] = Math.max(res[i-1][j], values[i-1] + res[i-1][j-weights[i-1]]);
				}
				
				
			}
		}
		
		return res[n][cap];
	}

}
