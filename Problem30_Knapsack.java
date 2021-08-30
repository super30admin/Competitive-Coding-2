// Time complexity: O(nc), n-> no. of items, c-> capacity
// Space complexity: O(nc), n-> no. of items, c-> capacity

class Solution {
    public int knapsackProblem(int[][] items, int capacity) {
        int[][] knapsackValues = new int[items.length + 1][capacity + 1];
        for(int i = 1; i < items.length + 1; i++) {
            int currentWeight = items[i - 1][1];
            int currentValue = items[i - 1][0];
            for(int c = 0; c < capacity + 1; c++) {
                if(c < currentWeight)
                    knapsackValues[i][c] = knapsackValues[i - 1][c];
                else
                    knapsackValues[i][c] = Math.max(knapsackValues[i - 1][c], knapsackValues[i - 1][c - currentWeight] + currentValue);
            }
        }
        return knapsackValues[items.length][capacity];
    }
}