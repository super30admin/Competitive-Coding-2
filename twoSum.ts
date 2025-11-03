// Time Complexity: O(n)
// Space Complexity: O(n)
function twoSum(nums: number[], target: number): number[] {
	const map = new Map<number, number>();

	for (let i = 0; i < nums.length; i++) {
		// check if the remaining needed for target already exist in the map
		if (map.has(target - nums[i])) {
			return [i, map.get(target - nums[i])];
		}

		if (!map.has(nums[i])) {
			// store the current number and its index in the map
			map.set(nums[i], i);
		}
	}
}
