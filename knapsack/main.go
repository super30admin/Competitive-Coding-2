package main

import "fmt"

func main() {
	fmt.Println(maxValue([]int{4, 5, 1}, []int{1, 2, 3}, 4))
}

// time: o(mn); where m is len(weights) and n is capacity
// space: o(mn)
func maxValue(weights []int, values []int, capacity int) int {
	m := len(weights) + 1
	n := capacity + 1

	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			weight := weights[i-1]
			value := values[i-1]
			currCap := j
			if weight > currCap {
				dp[i][j] = dp[i-1][j]
			} else {
				dp[i][j] = max(dp[i-1][j], value+dp[i-1][j-weight])
			}
		}
	}

	return dp[m-1][n-1]
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
