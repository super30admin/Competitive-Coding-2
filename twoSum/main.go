package main

// time: o(n)
// space: o(n)
func twoSum(nums []int, target int) []int {

	if nums == nil || len(nums) == 0 {
		return nil
	}

	state := map[int]int{}

	for i := 0; i < len(nums); i++ {
		py := target - nums[i]
		idx, seen := state[py]
		if seen {
			return []int{i, idx}
		}
		state[nums[i]] = i
	}
	return nil
}
