function twoSum(nums: number[], target: number): number[][] {
  let result: number[][] = [];
  let left = 0;
  let right = nums.length - 1;
  let flag = false;

  while (left < right) {
    let left_value = nums[left];
    let right_value = nums[right];
    if ((left_value + right_value) == target) {
      result.push([left_value, right_value]);
    }
    if (flag) {
      left++;
    } else {
      right--;
    }

    flag = !flag;
  }

  return result;
}

describe("Find Max Profit", () => {
  it("Happy Path", () => {
    let nums = [4, 9, 1, 0, 2, 3, 5, 6, 6, 1];
    let target = 7;
    expect(twoSum(nums, target)).toStrictEqual([
      [4, 3],
      [2, 5],
      [6, 1],
    ]);
  });
});
