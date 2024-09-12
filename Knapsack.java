package mock2;
//TC: O(nW) where n is the number of items and W is the capacity of knapsack.

public class Knapsack {
    int find(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String args[]){
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        System.out.println("The maximum value: "+ new Knapsack().find(50, wt, val, val.length));
    }
}