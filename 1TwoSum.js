/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
//Time: O(n)
//Space: O(n)
var twoSum = function (nums, target) {
  const lookup = new Map();

  for (let i = 0; i < nums.length; i++) {
    const difference = target - nums[i];

    if (lookup.has(difference)) {
      return [lookup.get(difference), i];
    }

    lookup.set(nums[i], i);
  }
};
