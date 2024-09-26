// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
fill a map with index of current element while looping through nums if not present
if complement of nums present in map and index is different from what is stored then return that element else nil
*/
package main

import "fmt"

func twoSum(nums []int, target int) []int {
	map1 := make(map[int]int)
	for i:= 0; i < len(nums); i++ {
		if val, ok := map1[target - nums[i]]; ok && val != i {
			return []int{i, val}
		}
		map1[nums[i]] = i
	}
	return nil
}

func Main2Sum() {
	fmt.Println(twoSum([]int{2,7,11,15}, 9)) // [0,1]
}
