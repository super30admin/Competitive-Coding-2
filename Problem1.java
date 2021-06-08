public class Interview {

    //0, 0, 0
    public int knapsack(int[] weights, int[] values, int index, int currentProfit, int remainingWeight) {

        //base case
        if (index == weights.length) {
            return currentProfit;
        }

        if (weights[index] > remainingWeight) {
            return currentProfit;
        }

        //logic
        int pickWeight = knapsack(weights, values, index + 1, currentProfit + values[index], remainingWeight - weights[index]);
        int dontPickWeight = knapsack(weights, values, index + 1, currentProfit, remainingWeight);

        return Math.max(pickWeight, dontPickWeight);
    }
