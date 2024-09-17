// Time Complexity : O(capacity * n )
// Space Complexity : O(capacity)
// Any problem you faced while coding this :  NO

public class Knapsack {
    public static void main(String[] args) {
        int[] values = new int[] {60,100,120};
        int[] weigths = new int[] {10,20,40};
        int capacity = 50;
        int[] dp = new int[capacity/10 + 1];
        
        for(int i = 0; i< values.length; i++){
            for(int j = 0; j < dp.length; j++){
                if(weigths[i] <= (j*10))
                    dp[j] = Math.max(dp[i], values[i] + dp[j- (weigths[i]/10)]);
            }
        }
        System.out.println(dp[dp.length-1]);
    }
}
