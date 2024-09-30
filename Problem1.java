// we will be using a dp array to track all the weights that can form the maximum value without exceeding the capacity. 
// Time complexity: O(n*m)
// Space Complexity: O(n)
public class Problem1 {
    public static int FindMaxWeight(int[] weights, int[] profit, int capacity){
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < weights.length; i++) {
            for (int j = capacity; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], profit[i] + dp[j - weights[i]]);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args){
        int result = FindMaxWeight(new int[] {4,5,1}, new int[] {1,2,3}, 4);
        System.out.println("The max value is: " + result);
    }
    
}
