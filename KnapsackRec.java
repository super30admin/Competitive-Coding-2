//Time Complexity: 2^N
//Space Complexity: N
// Runs on LeetCode Play Ground: Yes
public class KnapsackRec {
    public static void main(String[] args) {
        int[] profits = {1, 2, 3};
        int[] wts = {4,5,6};

        int result = knapsackRec(3, profits, wts, 3);

        System.out.print(result);
    }

    public static int knapsackRec(int W, int[] val, int[] wt,int  n ){

        // base
        if(n == 0 || W == 0) return 0;
        int choose =0;
        // recursive logic
        if(wt[n-1] <= W){
            choose = val[n-1] + knapsackRec( W - wt[n-1] , val, wt, n -1 );
        }
        int skip = knapsackRec( W , val, wt, n -1 );

        return Math.max(choose, skip);
    }
}