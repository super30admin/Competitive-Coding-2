//Knapsack Problem
//Time Complexity : O(m * n) //m = values.length, n = weights.length
//Space Complexity : O(m * n)

public class Main {
    public static int bag(int[] value, int[] weights, int capacityWeights){
        //checking if the input arrays are null or not of the same length
        if(value == null || value.length != weights.length || weights == null){
            return 0;
        }
        //creating a table to fill the values based upon the weights
    int[][] table = new int[weights.length + 1][capacityWeights + 1];
        //iterate through the table row
    for(int i = 0; i <= weights.length; i++){
        //iterate through the table column
        for(int j = 0; j <= capacityWeights; j++ ){
            if(i == 0 || j == 0){
                table[i][j] = 0; //filling up the 0th index of row and column with 0
            }
            //checking to see the weights array is <= the capacity of that index
           else if(weights[i-1] <= j){
               //Assign the max value between the value of the previous row and column to the current index
                table[i][j] = Math.max(value[i -1] + table[i-1][j - weights[i-1]] , table[i-1][j]);
            }
            else{
                //Assign the previous value as it is
                table[i][j] = table[i-1][j];
            }
        }
    }
        // return the max value of the index based on capacity.
        return table[value.length][capacityWeights];
}
    public static void main(String[] args) {
        int[] w  = {10,20,30};
        int[] v = {60,100,120};
        int cW = 50;
        System.out.println(bag(v,w,cW));
    }
}