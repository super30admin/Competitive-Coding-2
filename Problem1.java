/*
Time Complexity - O(M * N).
Space Complexity - O(M * N) where M is the number of items in val and N is the max capacity of the sack/bag.
*/
public class KnapSack {

	public static void main(String[] args) {
		
		int[] val = {60, 100, 90, 150, 300};
		int[] weight = {10, 20, 30, 40, 5};
		int capacity = 50;
		
		System.out.println(getMaxValue(val, weight, capacity));
	}

	private static int getMaxValue(int[] val, int[] weights, int capacity) {
		
		if(val == null || weights == null || val.length == 0 || weights.length == 0 || val.length != weights.length)
			return -1;
		
		int[][] result = new int[capacity + 1][val.length + 1];
		
		for(int curCap = 0; curCap <= capacity; curCap++) {
			for(int weight = 0; weight <= weights.length; weight++) {
				
				if(curCap == 0 || weight == 0)
					result[curCap][weight] = 0;
				else if(weights[weight - 1] > curCap) //cannot add a weight greater than capacity.
					result[curCap][weight] = result[curCap][weight - 1];
				else
					result[curCap][weight] = Math.max(result[curCap][weight - 1], 
													  val[weight - 1] + result[curCap - weights[weight - 1]][weight - 1]);
			}
		}
		
		return result[capacity][val.length];
	}
}
