/*
TC: O(2 ^ n)
SC: O(N) depends on implicit stack calls
 */

class KnapSackRecurssion{

    private int KnapSack(int[] weights, int[] values, int W){

        return helper(weights,values,W, 0);
    }

    private int helper(int[] weights, int[] values, int W, int index){
        if (W == 0 || index == weights.length){
            return 0;
        }
        if (weights[index] <= W){
            return Math.max((values[index] + helper(weights,values,W-weights[index],index)),
                    helper(weights,values,W,index+1));
        }
        else{
            return helper(weights,values,W,index+1);
        }
    }
}