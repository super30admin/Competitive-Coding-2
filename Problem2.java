import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Two Sum Problem
// Time Complexity: O(n) where n is number of elements in nums
// Space Complexity: O(n) where n is number of elements in nums
public class Problem2 {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}