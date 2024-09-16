/* Time complexity: we are finding maximum value for every weight from 0 to required weight by
                    adding each of the given weights at a time. So TC will be O(n*m) where
                    n is weights array length, m is knapsack weight.
*  Space complexity: Since we are calculating maximum possible value for every weight by building
*                   a matrix, SC will be O(n*m) where n is weights array length, m is knapsack weight.
*
* */

public class Knapsack01 {
    public static void main(String args[]){
        int[] values = {60,100,120};
        int[] weights = {10,20,30};
        int weight = 50;
        System.out.print(knapSack(weights,values,weight));
    }

    public static int knapSack(int[] weights, int[] values, int requiredWeight){
        int numberOfWeights = weights.length;
        int[][] dpArray = new int[numberOfWeights+1][requiredWeight+1];
        // we are calculating value for every possible weight from 0 to required weight

        for(int i=0; i<=numberOfWeights; i++){
            for(int w=0 ; w <= requiredWeight; w++){
                if(i==0 || w ==0)
                    dpArray[i][w] = 0;
                else if(w >= weights[i-1]){
                    dpArray[i][w] = Math.max(dpArray[i-1][w],
                                        (values[i-1] + dpArray[i-1][w-weights[i-1]]));
                 }else {
                    dpArray[i][w] = dpArray[i-1][w];
                }
            }
        }
        return dpArray[numberOfWeights][requiredWeight];
    }

}
