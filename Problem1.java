//Knapsach

//Time complexity : o(m*n)
//Space complexity: o(m*n)

int knapsackDP(int[] w, int[] v, int n, int W) {
    if (n <= 0 || W <= 0) {
        return 0;
    }
    int[][] m = new int[n + 1][W + 1];
    for (int j = 0; j <= W; j++) {
        m[0][j] = 0;
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= W; j++) {
            if (w[i - 1] > j) {
                m[i][j] = m[i - 1][j];
            } else {
                m[i][j] = Math.max(
                  m[i - 1][j],
                  m[i - 1][j - w[i - 1]] + v[i - 1]);
            }
        }
    }
    return m[n][W];
}
