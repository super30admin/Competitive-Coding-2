// Time Complexity : O(n2)
// Space Complexity : O(nc)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
init a 2d array of size arr+1, c+1
first row and col =0
from 1st row prev = lastrow value, curr =0
if capacity is greater that weight of previous then
update curr += profit from remaining weight
update element as max of prev and curr
return last element
*/

package main

import "fmt"

func knap(w []int, p []int, c int) int {
	if c == 0 || len(w) == 0 || len(p) == 0 || len(w) != len(p) {
		return 0
	}
	arr := make([][]int, len(w) + 1)
	for i:= 0;i < len(arr);i++ {
		arr[i] = make([]int, c + 1)
	}

	for i:= 1;i < len(arr);i++ {
		for j:=1;j<= c;j++ {
			prev := arr[i - 1][j]
			curr := 0
			if (c >= w[i - 1 ]) {
				curr = p[i - 1]
				if j - w[i - 1] > 0 {
					curr += arr[i - 1][j - w[i - 1]]
				}
			}
			arr[i][j] = max(prev, curr)
		}
	}

	return arr[len(w)][c]
}

func max(a, b int) int {
	if a>b {
		return a
	}
	return b
}
func MainKnapsack() {
	fmt.Println(knap([]int {1,2,3}, []int{60, 100, 120}, 5))
}
