
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no
import java.util.Arrays;

public class Problem2 {

    int dp [][];

    public int maxValue(int [] weights, int [] values, int capacity){
        dp = new int[weights.length][capacity + 1];
        return getValue(weights, values, capacity, 0);
    }

    public int getValue(int [] weights, int []values, int capacity, int index){

        if (capacity <= 0 || weights.length == index) {
            return 0;
        }

        if (dp[index] [capacity]== 0) {
            if (weights[index] <= capacity) {
                int selected = values[index] + getValue(weights, values, capacity - weights[index], index + 1);
                int notSelected = getValue(weights, values, capacity, index + 1);
                return dp[index][capacity]  =  Math.max(selected, notSelected);
            }
        }

        return dp[index][capacity];
    }


    public static void main(String[] args) {

        Problem2 obj = new Problem2();
        int [] weights = {6,25,20,30};
        int [] values =  {60,100,60,120};
        System.out.println(obj.maxValue(weights, values, 60));
    }
}