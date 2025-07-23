//Time Complexity (TC):O(n × W) -Where n = number of items, W = max capacity. We loop through n items and for each, iterate W capacities.
//Space Complexity (SC):O(W). Only one 1D array dp[] of size W+1 is used.

//Use a 1D dp[] array where dp[c] stores the max profit for capacity c.
//For each item, iterate capacities in reverse from maxCapacity down to weight[i].
//Update dp[c] = max(dp[c], profit[i] + dp[c - weight[i]]) to decide whether to include the item.



class Solution {

    public static int findMaxProfit(int[] itemWeights, int[] itemProfits, int maxCapacity) {
        int capacity = maxCapacity;
        int totalItems = itemWeights.length;
        int[] dp = new int[capacity + 1];

        for (int itemIndex = 0; itemIndex < totalItems; itemIndex++) {
            for (int currentCapacity = capacity; currentCapacity >= itemWeights[itemIndex]; currentCapacity--) {
                dp[currentCapacity] = Math.max(dp[currentCapacity], itemProfits[itemIndex] + dp[currentCapacity - itemWeights[itemIndex]]);
            }
        }

        return dp[capacity];
    }

    public static void main(String args[]) {
        int[] itemWeights = {10, 20, 30, 40};
        int[] itemProfits = {130, 110, 170, 190};
        int maxCapacity = 50;

        System.out.println(findMaxProfit(itemWeights, itemProfits, maxCapacity));
    }
}
