//Time Complexity O(m*n)
//Space Complexity O(m*n)
//where m = weight and n = capacity

class week2 {

    public int solution(int[] weight, int[] value, int capacity) {
        if (weight.length == 0 || value.length == 0 || weight.length != value.length) return -1;
        return findSolution(weight, value, capacity);
    }

    private int findSolution(int[] weight, int[] value, int capacity) {
        int[][] dp = new int[weight.length + 1][capacity + 1];
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[weight.length][capacity];
    }


    public int recursionSolution(int[] weight, int[] value, int capacity) {
        return findRecursionSolution(weight, value, capacity, 0, 0);
    }

    private int findRecursionSolution(int[] weight, int[] value, int capacity, int index, int total) {
        if (capacity == 0) {
            return total;
        }
        if (capacity < 0 || index == weight.length) {
            return -1;
        }
        //logic
        //choose case without subtracting index value
        int value1 = findRecursionSolution(weight, value, capacity, index + 1, total);
        //choose case with subtracting index value
        int value2 = findRecursionSolution(weight, value, capacity - weight[index], index + 1, total + value[index]);
        if (value1 == -1) {
            return value2;
        }
        if (value2 == -1) {
            return value1;
        }
        return Math.max(value1, value2);
    }

    public static void main(String[] args) {
        int[] weight = {1, 2, 3, 8, 7, 4};
        int[] value = {25, 10, 40, 15, 25, 10};
        int capacity = 10;

        week2 week2 = new week2();
        int finalValue = week2.solution(weight, value, capacity);
        System.out.println("final value " + finalValue);
        int finalValueRecursion = week2.recursionSolution(weight, value, capacity);
        System.out.println("final value " + finalValueRecursion);

    }
}
