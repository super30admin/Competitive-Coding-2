public class KnapSackSolution {
     public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };

        // int val[] = new int[] { 10, 20, 30, 40, 50 };
        // int wt[] = new int[] { 100, 10, 120, 5, 70 };

        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n, 0, 0));
    }

    private static int knapSack(int W, int[] weights, int[] val, int n, int max, int index){
        if(n == 0) return -1;
        if(W < 0){
            return -1;
        }

        if(W == 0){
            return max;
        }
        if(index >= n) {
            return max;
        }
        // logic
        // not choose
        if (weights[index] > W) {
           return knapSack(W, weights, val, n, max, index + 1);
        }else{
          int case0 = knapSack(W, weights, val, n, max, index + 1);
          //int choose
          int case1 = knapSack(W - weights[index], weights, val, n, max + val[index], index + 1);
          return Math.max(case0, case1);
        }


    }
}
