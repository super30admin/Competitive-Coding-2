// 0/1 Knapsack
// Time Complexity : O(2^N) because of recusrion tree
// Space Complexity : O(N) because of recursion stack

class Knapsack 
{ 
	static int K(int C, int n, int weight[], int value[])
	{
		if (C == 0 || n == 0) return 0;
		if (weight[n-1] > C) return K(C, n-1, weight, value);
		else return Math.max(K(C-weight[n-1], n-1, weight, value)+value[n-1], K(C, n-1, weight, value));
	}
    public static void main(String args[]) 
    { 
    int value[] = new int[]{60, 100, 120}; 
    int weight[] = new int[]{10, 20, 30}; 
    int  C = 50; 
    int n = value.length; 
    System.out.println(K(C, n, weight, value)); 
    } 
} 