// Time Complexity : O(NW)
// Space Complexity : O(NW)
// W is the total weight

class knapsack {
    static int knapSack(int W, int[] wt, int[] v, int n) {
        //initializing an array with size of given W +1
        int[][] k = new int[n+1][W+1];
        //iterating over the elements in the arrays
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                 //base case, if items and weights in the array are not given
                if(i==0||j==0){
                    k[i][j]=0;
                }
                // getting value from above row till j is less than i-1th row
                else if (wt[i - 1] > j) {
                    k[i][j] = k[i - 1][j];
                }
                //else checking the last items weights
                else {
                    //if the weight of the ith item is not exceeding the capacity then taking the max value among previous row value-weight and previous [row value,(weight-weight of that item)]+value of that item
                    k[i][j] = Math.max(k[i - 1][j], v[i - 1] + k[i - 1][j - wt[i - 1]]);
                }
            }
        }
        // returning the max value of knapsack
        int result = k[k.length - 1][k[0].length - 1];
        return result;
    }
    public static void main(String args[]) {
        int v[] = new int[] { 60, 100, 120, 160 };
        int wt[] = new int[] { 10, 20, 30, 50 };
        int W = 70;
        int n = v.length;
        System.out.println(knapSack(W, wt, v, n));
    }
}