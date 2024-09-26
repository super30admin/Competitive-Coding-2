//Time Complexity : O(M x N);
//Space Complexity :O(M x N)


class Problem2{

    public static int knapsack(int[] values, int[] weight, int capacity){
        if(values == null || values.length == 0 || values.length != weight.length || capacity == 0) return 0;

        int[][] dp = new int[values.length + 1][capacity + 1];

        for(int i = 1; i <= values.length; i++){
            for(int j = 1; j <= capacity; j++){
                int c = 0;
                int dc = dp[i-1][j];
                if(j >= values[i - 1])
                    c = weight[i - 1] + dp[i-1][j - values[i - 1]];
                dp[i][j] = Math.max(c, dc);
            }
        }

        return dp[values.length][capacity];
    }


    public static void main(String[] args) {
        System.out.println(knapsack(new int[]{1, 2, 3}, new int[]{6, 10, 12}, 5));
    }

}