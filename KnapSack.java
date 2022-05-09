//Time Complexity : O(M*N) N = maxCapactiy
//Space Complexity: O(M*N)

// "static void main" must be defined in a public class.
class KnapsackProblem {
    public int findMaxCapacity(int[] weights, int[] values, int maxWeight) {
        int[][] mapping = new int[weights.length + 1][maxWeight + 1];
        for(int i=1;i<=weights.length;i++) {
            for(int j=0;j<=maxWeight;j++) {
                if(j< weights[i-1]) {
                    mapping[i][j] = mapping[i-1][j];
                } else {
                    // we calculate the current values by the max of value from
                    // between above weight and value associated to current weight
                    // plus value with respect to remaining weight to be fulfilled from above weight
                    // as same weight should not be used again
                    mapping[i][j] = Math.max(mapping[i-1][j], values[i-1]+mapping[i-1][j-weights[i-1]]);
                }
            }
        }
        return mapping[weights.length][maxWeight];
    }
    public static void main(String[] args) {
        KnapsackProblem kp = new KnapsackProblem();
        int[] weight = {10,20,30};
        int[] values = {60,100,120};
        int maxCapacity = 50;
        System.out.println(kp.findMaxCapacity(weight,values,maxCapacity));
    }
}