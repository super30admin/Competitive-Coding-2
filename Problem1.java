class KnapSack{

    static int knapSack(int W, int wt[], int val[], int n){
        return exhaustive_knapSack(wt, val, W,0, 0);
//        return dp_knapsack(wt, val, W);
    }

    static int exhaustive_knapSack(int wt[], int val[], int remainingCapacity, int index, int max_profit){

        //base
        //reached end of array
        if(index >= wt.length) return max_profit;
        //remaining capacity < weight at index
        if(wt[index] > remainingCapacity)
//            return  exhaustive_knapSack(wt, val, remainingCapacity, index + 1, max_profit);
            return max_profit;

        //logic
        //choose weight
        int case1 = exhaustive_knapSack(wt, val, remainingCapacity - wt[index],
                index +1, max_profit + val[index]);

        //not choose weight
        int case2 = exhaustive_knapSack(wt, val, remainingCapacity, index +1, max_profit);
        return Math.max(case1, case2);
    }

    public static int dp_knapsack(int[] W, int[] V, int capacity){

        int len1 = W.length;
//        int len2 = V.length;
        int[][] dp = new int[len1+1][capacity+1];

        for(int row = 1; row < len1+1; row++){
            for(int col = 1; col < capacity+1; col++){
                if(col < W[row-1])
                    dp[row][col] = dp[row-1][col];
                else{
                    dp[row][col] = Math.max(dp[row-1][col],
                            dp[row-1][col - W[row-1]] + V[row-1]);
//                    dp[row][col] =   Math.max(dp[row-1][col],
//                            V[row-1] + dp[row-1][col-W[row-1]]);
                    if(row == 3 && col > 4){
                        System.out.println("row : " + row);
                        System.out.println("col : " + col);
                        System.out.println("row-1 : " + (row-1));
                        System.out.println("col-W[row-1] : " + (col-W[row-1]));
                        System.out.println("same col, previous row value : " + dp[row-1][col]);
                        System.out.println("V[row-1] : " + V[row-1]);
                        System.out.println("dp[row-1][col-W[row-1]] : " + dp[row-1][col-W[row-1]]);
                        System.out.println("---------------");
                    }
                }
            }
        }
        System.out.println("1 2 3 4 5 6 7 8");
        for(int row = 1; row < len1+1; row++){
            for(int col = 1; col < capacity+1; col++){
                System.out.print(dp[row][col] + " ");
            }
            System.out.println();
        }
        return dp[len1][capacity];

    }
    public static void main(String[] args){
//        System.out.println("Highest Profit "+ knapSack(8, new int[]{2,3,5}, new int[]{1,2,6}, 3));
        System.out.println("Highest Profit "+ knapSack(8, new int[]{2,3,5}, new int[]{1,2,6}, 3));
    }

}