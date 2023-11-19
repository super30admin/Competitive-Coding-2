// Time Complexity : O(m*n)
// Space Complexity : O(m*n)

//dp matrix is used to solve, with items and the capacity
public class Main
{
    public static void main(String args[])
    {
        int items[] = new int[] { 1, 2, 3 };
        int profit[] = new int[] { 10, 15, 40 };
​
        int capacity = 6;
        System.out.println(calculateMaxProfit(capacity, items, profit));
    }
​
    static int calculateMaxProfit(int capacity,  int items[], int profit[]){
        int dp[][] = new int[items.length+1][capacity+1];
        for(int i=1;i<=items.length;i++){
            for(int j=1;j<=capacity;j++){
                if(j< items[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i-1]]+profit[i-1]);
                }
            }
        }
        return dp[items.length][capacity];
    }
}