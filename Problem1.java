import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n) as array is traversed.
// Space Complexity: O(n) as Map is used to insert and look up

// I am using HashMap for searching/look up once i populate it with the elements and its index. As it has O(1) time complexity.
public class Problem1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumWithExtraForLoop(new int[] { 2, 5, 7, 11 }, 9))); // 0,2
        System.out.println(Arrays.toString(twoSumWithExtraForLoop(new int[] { 2, 3, 4, 4 }, 7))); // 1,2 or 1,3

        System.out.println(Arrays.toString(twoSumSingleForLoop(new int[] { 2, 5, 7, 11 }, 9))); // 0,2
        System.out.println(Arrays.toString(twoSumSingleForLoop(new int[] { 2, 3, 4, 4 }, 7))); // 1,2 or 1,3
    }

    private static int[] twoSumWithExtraForLoop(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            // The second condition is important which seeks other index rather than the
            // same index.
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }
        }
        // returns an empty array in case of not finding any thing
        return new int[] {};
    }

    private static int[] twoSumSingleForLoop(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // The second condition is important which seeks other index rather than the
        // same index.
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i]))
                return new int[] { i, map.get(target - nums[i]) };
            map.put(nums[i], i);
        }
        // returns an empty array in case of not finding any thing
        return new int[] {};
    }

}