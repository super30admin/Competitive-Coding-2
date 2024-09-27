//Knapsack 0/1

// Time Complexity :O(n)
// Space Complexity :O(n)
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Used recurrence realation:- T(c,w) = t(c,w-1) + t(c-1,w-1) 
class Knapsack{
    private static int knapsack(int[] value, int[] weights, int capacity) {
        //edge case
        if(capacity ==0 || weights.length==0) return 0;

        int[] [] dp = new int[weights.length+1][capacity+1];

        for(int i = 1; i <dp.length;i++)
        {
            for(int j = 1 ; j <dp[0].length;j++)
            {
                // Check if capcity is greater than my weight
                if(j>=weights[i-1])
                {
                    dp[i][j] = dp[i][j-weights[i-1]] + value[i-1]; 
                }
                else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[weights.length][capacity];
    }
    public static void main(String [] args)
    {
        int[] v = { 10, 40, 50, 70 };
        int[] w = { 1, 3, 4, 5};
        int c = 7;
        System.out.println(knapsack(v, w, c));
    }
}