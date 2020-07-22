// Time Complexity : O(n) , n is length of weight array

// Space Complexity : O(1)

public class Solution {
	int[] v;
	int[] w;
	int capacity;

	Solution(int[] v, int[] w) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
	}

	private int findMaxValue(int capacity) {
		this.capacity = capacity;
		return helper(0, 0, 0);
	}

	private int helper(int index, int weight, int value) {
		if (index >= w.length || weight == capacity)
			return value;

		int num1, num2;

		// choose the index
		if (weight + w[index] <= capacity)
			num1 = helper(index + 1, weight + w[index], value + v[index]);
		else // if its over the capacity then don't loose the previous progress and continue
			num1 = helper(index + 1, weight, value);

		num2 = helper(index + 1, weight, value);
		return Math.max(num1, num2);
	}

	public static void main(String[] args) {
		int[] v = new int[] { 60, 100, 120, 180 };
		int[] w = new int[] { 10, 20, 30, 20 };
		Solution obj = new Solution(v, w);
		System.out.print(obj.findMaxValue(50)); // capacity
	}
}