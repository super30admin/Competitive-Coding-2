import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//Time Complexity: O(max)
//Space Complexity: O(max)
//Did this code successfully run on Leetcode : Yes
//Approach: Keep adding the elements in the seen map until you find that target - num is present in the seen map, at which point the target will become 0
//return the current index and the index for (target - num) in the seen map
/**
 * Returns the indices whose values on summing up equals the target
 */
public class TwoSum {

    /**
     *
     * @param nums   the nums array
     * @param target the target
     * @return       the indices whose values on summing up equals the target
     */
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!seen.containsKey(target - nums[i])) seen.put(nums[i], i);
            else return new int[] {i, seen.get(target - nums[i])};
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        final TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2, 8, 11, 7, 15}, 9))); //return [3, 0]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3, 2, 4}, 6))); //return [2, 1]
    }
}
