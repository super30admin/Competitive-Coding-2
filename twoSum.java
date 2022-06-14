//time complexity: O(n)
//space complexity: O(n)

import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static int[] getTwoSum(int[] nums, int target) {
        int[] result = new int[2];
        int n = nums.length;

        // null case
        if (nums == null || n == 0)
            return result;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hMap.containsKey(target - nums[i])) {
                result[0] = hMap.get(target - nums[i]);
                result[1] = i;
            } else {
                hMap.put(nums[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(getTwoSum(nums, target)));
    }
}
