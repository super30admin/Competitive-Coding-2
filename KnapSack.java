// Time Complexity : O(n * m) 
// Space Complexity : O(2m)

public class KnapSack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        return helper(weight, value, n, maxWeight);

    }

     private static int helper(int[] weight, int[] value, int n, int capacity) {


        int [] prev = new int [capacity + 1];
        int [] current = new int [capacity + 1];

        for(int w = weight[0]; w <=capacity; w++) {
            if(weight[0] <= capacity) {
                prev[w] = value[0];
            }else {
                prev[w] = 0;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int w = 0; w <= capacity; w++) {
                int choose = 0;
                if (weight[i] <= w) {
                    choose = value[i] + prev[w - weight[i]];
                }
                int notChoose = 0 + prev[w];
                current[w] = Math.max(choose, notChoose);
            }
            prev = current;
            current = new int[capacity+1];
        }

        return prev[capacity];

    }
}