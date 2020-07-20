public class Knapsack {
    //Approach 1 
    //Time Complexity = O(weight * capacity)
    //Space Complexity = O(weight * capacity)
    public static int valueCalculate(int[] weight, int[] values, int capacity){
        int dp[][] = new int [weight.length+1][capacity+1];
        for(int i = 0; i <= weight.length;i++){dp[i][0] = 0;}
        for(int i = 0; i <= capacity;i++){dp[0][i] = 0;}

        for(int i = 1; i <=weight.length;i++){
            for(int j = 1; j <= capacity;j++){
                
                if(weight[i-1]>j) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j],values[i-1]+dp[i-1][j-weight[i-1]]);
                } 
            }
        }
        return dp[weight.length][capacity];
    }
    // Approach 2 - recusrive
    //Time Complexity = O(2 ^ length of weight)
    //Space Complexity = O(length of weight)

    public static int recursiveCalculate(int[] weight,int[] values,int capacity, int n){
        if(n == 0 || capacity ==0) return 0;
        if(weight[n-1] > capacity){
            return recursiveCalculate(weight, values, capacity, n-1);
        }
        else{
            return Math.max(
                recursiveCalculate(weight, values, capacity, n-1),
                values[n-1]+recursiveCalculate(weight, values, capacity-weight[n-1], n-1)
            );
        }
    }
    public static void main(String args[]){
        System.out.println(valueCalculate(new int[]{1,2,3},new int[]{10,15,40},6));
        int [] weight = new int[]{1,2,3};
        int [] values = new int[]{10,15,40};
        int n = weight.length;
        int capacity = 6;
        System.out.println(recursiveCalculate(weight, values, capacity, n));

    }
    
}