/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * 
 * we are given weights and values of n items. 
 * we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.
 * or we can say that we are given two integers arrays val[0......n-1] and wt[0.....n-1] 
 * which represent values and weights associated with n items respectively. 
 * we are also given an integer W  which represents knapsack capacity.
 * 
 * find out the maximum value subset of val[] such that 
 * sum of the weights of this subset is smaller than or equal to W. 
 * 
 * but you cannot break an item, either pick the complete item 
 * or dont pick it(known as 0-1 property).
 * 
 * Exhaustive Approach(Iterative)
 * 
 * time: n^2
 * space:O(1)
 */
class KnapsackExhaustiveIterative {
    public int maxValue(int[] weights, int[] values, int capacity){
        if(weights == null || values == null || 
        weights.length == 0 || values.length == 0) return 0;

        int n = weights.length;
        int max = 0; // max within the i value combinations

        for (int i = 0; i < n; i++) {
            int currWeight = weights[i];
            int currValue = values[i];
            int currMax = 0; // max within the j value combinations

            for (int j = 0; j < n; j++) {
                if (j==i) continue;
                if ((currWeight + weights[j]) >= capacity){
                    currWeight -= weights[j-1];
                    currValue -= values[j-1];
                }
                if ((currWeight + weights[j]) <= capacity) {
                    currWeight += weights[j];
                    currValue += values[j];
                } 
                currMax = Math.max(currMax, currValue);
            }

            max = Math.max(max, currValue);
        }

        return max;
    }
}

/**
 * 
 * Exhaustive Approach(Recursive)
 * Top Down Approach 1
 * 
 * time: n^2
 * space:O(n^2)
 */
class KnapsackExhaustiveRecursive {
    public int maxValue(int[] weights, int[] values, int capacity){
        if (weights == null || values == null || 
        weights.length == 0 || values.length == 0) return 0;

        return helper(weights, values, capacity, 0);
    }

    public int helper(int[] weights, int[] values, int capacity, int i){
        // base
        if (i == weights.length-1 || capacity == 0) return 0;

        // logic
        if(weights[i+1] > capacity){
            // dont choose
            return helper(weights, values, capacity, i+1);
        } else {
            // dont choose
            int case1 = helper(weights, values, capacity, i+1);

            // choose
            int case2 = values[i+1] + helper(weights, values, capacity - weights[i+1], i+1);
            
            return Math.max(case1, case2);
        }

    }
}

/**
 * 
 * Exhaustive Approach(Recursive)
 * Top Down Approach 2
 * 
 * time: n^2
 * space:O(n^2)
 */
class KnapsackExhaustiveRecursive1 {
    public int maxValue(int[] weights, int[] values, int capacity){
        if (weights == null || values == null || 
        weights.length == 0 || values.length == 0) return 0;

        return helper(weights, values, capacity, 0);
    }

    public int helper(int[] weights, int[] values, int capacity, int i){
        // base
        if (i == weights.length-1 || capacity <= 0) return 0;

        // logic
        // dont choose
        int case1 = helper(weights, values, capacity, i+1);

        // choose
        int case2 = values[i] + helper(weights, values, capacity - weights[i], i+1);
        
        return Math.max(case1, case2);
    }
}

/**
 * 
 * Exhaustive Approach(Recursive)
 * My Original Approach
 * 
 * time: n^2
 * space:O(n^2)
 * 
 * Was Failing : because of using i++ as it post increments
 * Passed : by using ++i or i+1
 */
class KnapsackExhaustiveRecursive2 {
    public int maxValue(int[] weights, int[] values, int capacity){
        if (weights == null || values == null || 
        weights.length == 0 || values.length == 0) return 0;

        return helper(weights, values, capacity, 0, 0, 0);
    }
    // 
    public int helper(int[] weights, int[] values, int capacity, int i, int currWeight, int currValue){
        // base
        if (currWeight > capacity) return 0;
        if (currWeight <= capacity && (i > weights.length-1)) return currValue;

        // logic
        // dont choose
        int case1 = helper(weights, values, capacity, i+1, currWeight, currValue);

        // choose
        int case2 = helper(weights, values, capacity, i+1, currWeight+weights[i], currValue+values[i]);
        
        return Math.max(case1, case2);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {1, 2, 5, 6};
        int capacity = 8;

        // int result = new KnapsackExhaustiveIterative().maxValue(weights, values, capacity);
        // System.out.println(result);

        int result2 = new KnapsackExhaustiveRecursive2().maxValue(weights, values, capacity);
        System.out.println(result2);
    }
}