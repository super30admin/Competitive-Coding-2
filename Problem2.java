import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Approach: HashMap
// Time: O(N)
// Space: O(N) for HashMap
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (indexMap.containsKey(target - nums[i])) {
                return new int[] {indexMap.get(target - nums[i]), i};
            }
            indexMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        Solution ob = new Solution();

        int[] nums1 = {2,7,11,15};
        System.out.println(Arrays.toString(ob.twoSum(nums1, 9))); // returns [0, 1]

        int[] nums2 = {3,2,4};
        System.out.println(Arrays.toString(ob.twoSum(nums2, 6))); // returns [1, 2]

        int[] nums3 = {3,3};
        System.out.println(Arrays.toString(ob.twoSum(nums3, 6))); // returns [0, 1]

        int[] nums4 = {3};
        System.out.println(Arrays.toString(ob.twoSum(nums4, 3))); // throws exception

        int[] nums5 = {};
        System.out.println(Arrays.toString(ob.twoSum(nums5, 0))); // throws exception

        int[] nums6 = {2, 3};
        System.out.println(Arrays.toString(ob.twoSum(nums6, 4))); // throws exception
    }
}