// 0/1 knapsack problem
//Time complexity: O(N)
//Space complexity: O(n), because of recursive stack
public class Main {
    static int case1 = 0;
    static int case2 = 0;
    public static void main(String[] args) {
      int N = 3;
      int W = 3;
      int values[] = {1, 2, 3};
      int weight[] = {4,5,1};
      System.out.println(helperMethod(values, weight, 0, W, 0));
    }

    private static int helperMethod(int[] values, int[] weight, int index, int W, int max) {
        //base case
        if(index == values.length) {
            return max;
        }
        //if weight of an item is more than the maximum capacity of knapsack
        //we will skip that item
        if(weight[index] > W) {
            return helperMethod(values, weight, index + 1, W, max);
        }
        else {
            //choose
            case1 = helperMethod(values, weight, index + 1, W - weight[index], max + values[index]);
            //not choose
            case2 = helperMethod(values, weight, index + 1, W, max);
        }
        return Math.max(case1, case2);
    }
}