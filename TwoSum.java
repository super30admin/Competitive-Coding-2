import java.util.HashMap;

/**
 * Time complexity: O(n) traverse the list containing n elements only once. Each lookup in the table costs only O(1) time.
 * Space complexity: O(n) The extra space required depends on the number of items stored in the hash table,
 * which stores at most n elements.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};
    }
}
