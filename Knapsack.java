import java.io.*;
class KnapSack {
    public int knapsack(int [] profit,int[]weights,int capacity){
        if(weights.length!=profit.length || profit.length==0)
            return 0;
        int result =0;
        int max =0;
        int [][]tabluation = new int[weights.length][capacity+1];
        for(int i=0; i < weights.length; i++){
            tabluation[i][0] = 0;
        }
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c)
                tabluation[0][c] = profit[0];
        }
        for(int i=1;i<weights.length;i++){
            for(int j=1;j<=capacity;j++){
                if(weights[i]<=j){
                    tabluation[i][j] = Math.max(tabluation[i-1][j],tabluation[i-1][j-weights[i]]+profit[i]);
                }
            }
            result = tabluation[weights.length-1][capacity];
        }
        return result;
    }
    public static void main (String[] args) {
        KnapSack k = new KnapSack();
        int profit[] = {1,2,6};
        int weights [] = {2,3,5};
        int capacity = 8;
        int max = k.knapsack(profit,weights,capacity);
        System.out.println("maximum profit : "+max);

    }
}