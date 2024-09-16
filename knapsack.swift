func MaxCapacity (_ values : [Int], _ weights: [Int], _ capacity: Int) -> Int {
        var dp = Array(repeating: Array(repeating: 0, count: capacity + 1), count : values.count + 1)
        for i in 1...values.count {
            for j in 1...capacity {
                if j < weights[i-1] {
                    dp[i][j] = dp[i-1][j]
                } else {
                    dp[i][j] = max(dp[i-1][j],dp[i-1][j-weights[i-1]] + values[i-1])
                }
            }
        }
        return dp[values.count][capacity]
    }
print(MaxCapacity([10,6,12],[2,1,3],5))