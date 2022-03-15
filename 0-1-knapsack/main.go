package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(knapsack([]int{2, 3, 6}, []int{60, 100, 120}, 10))
}

// time: o(mn) ----  m: weights, n:cap
// space: o(mn) ---- m: weights, n:cap
func knapsack(weights, vals []int, cap int) int {
	if len(weights) != len(vals) || cap == 0 {
		return 0
	}
	m := len(weights) + 1
	n := cap + 1
	dp := make([][]int, m)
	for idx, _ := range dp {
		dp[idx] = make([]int, n)
	}

	for i := 1; i < m; i++ { // i == weights
		for j := 1; j < n; j++ { // j == cap
			itemIdx := i - 1
			itemWeight := weights[itemIdx]
			itemVal := vals[itemIdx]
			if itemWeight > j {
				dp[i][j] = dp[i-1][j]
			} else {
				dp[i][j] = int(math.Max(float64(dp[i-1][j]), float64(itemVal+dp[i-1][j-itemWeight])))
			}
		}
	}
	return dp[m-1][n-1]
}

func helper(weights, vals []int, cap int, i int, earnings int) int {
	// base
	if cap <= 0 {
		return 0
	}
	if cap == 0 || i > len(weights)-1 {
		return earnings
	}

	// logic
	choose := helper(weights, vals, cap-weights[i], i+1, earnings+vals[i])
	notChoose := helper(weights, vals, cap, i+1, earnings)
	return int(math.Max(float64(choose), float64(notChoose)))
}
