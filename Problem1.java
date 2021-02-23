// 0-1 Knapsack
class Solution {
    /*
    Time complexity: O(n*m)
    Space complexity: O(n*m)
    */

    public int knapsack(int[] arr, int[] val, int wt){

        // initialize the mat[][]
        int n = arr.length + 1;
        int m = wt + 1;
        int[][] mat = new int[n][m];

        // initially the first row and column in mat will be 0
        // for 0 capacity no weight will be chosen
        for(int i = 0; i < n; i++){
            mat[i][0] = 0;
        }

        // for any capacity if the weight is 0 then there is no way to fill the knapsack so add 0
        for(int j = 0; j < m; j++){
            mat[0][j] = 0;
        }

        for(int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                // if the weight is more than the knapsack capacity then
                if(arr[i-1] > j) {
                    // update it with the above value in mat
                    mat[i][j] = mat[i-1][j];
                }
                else {
                    // otherwise update it with the sum of value for that weight 
                    //and already calculated value for j - arr[i-1] capacity
                    mat[i][j] = val[i-1] + mat[i-1][j - arr[i-1]];
                }
            }
        }

        // optimal solution
        return mat[n-1][m-1];
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] arr = {2, 3, 5};
        int[] val = {1, 2, 6};
        int wt = 8;
        System.out.println(sol.knapsack(arr, val, wt));
    }
}