//Tc : o(mn)
//SC : o(mn)
//0-1 Knapsack Problem | DP-10

class Weights{
	private int maxValue(int[] weights, int[] values, int capacity){
			int [][] matrix = new int [weights.length+1][capacity+1];
			
			for(int i=1;i<matrix.length;i++){
				for(int j=1; j<=capacity; j++){
					if(j<weights[i-1]){
						matrix[i][j] = matrix[i-1][j];
					}else {
						matrix[i][j] = Math.max(matrix[i-1][j],values[i-1]+matrix[i-1][j-weights[i-1]]);
					}
				}
				
			}
			return matrix[matrix.length-1][capacity];
	}
}
