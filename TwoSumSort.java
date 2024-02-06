import java.util.Arrays;

// TC - O(N logN)
// SC - O(N)

// Constraints:
// 2 <= nums.length <= 10^4
// -10^9 <= nums[i] <= 10^9
// -10^9 <= target <= 10^9
// Only one valid answer exists.

public class TwoSumSort {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] copyArr = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copyArr);
            int[] result = new int[] { -1, -1 };
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int sum = copyArr[left] + copyArr[right];
                if (sum == target) {
                    break;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (copyArr[left] == nums[i] && result[0] == -1) {
                    result[0] = i;
                }

                if (copyArr[right] == nums[i] && result[0] != i) {
                    result[1] = i;
                }

                if (result[0] != -1 && result[1] != -1) {
                    return result;
                }
            }

            return result;
        }
    }
}