/**
 * Problem: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * Time complexity is O(nm) where n is number of weight and m is total number of capactity to achiece
 * Space complexity: O(nm) same as above
 *
 *
 */
class solution {
    public static void main(String[] args) {
        int weightAch = 50;
        int weights[] = {10, 20, 30};
        int values[] = {60, 100, 120};

        int[][] dp = new int[weights.length + 1][weightAch + 1];

        for (int i = 1; i < weights.length + 1; i++){
            int currentWeight = weights[i - 1];
            for(int j = 1; j < weightAch + 1; j++){
                //if current weight in hand is less than to achieve then there are 2 possibilities
                //1. chosse the element and see rest of the combination in stored array
                //2. don't chosse element and that is already stored in 2D array
                if(currentWeight <= j){
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i -1][j - currentWeight]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Max weight" + dp[weights.length][weightAch]);
    }
}