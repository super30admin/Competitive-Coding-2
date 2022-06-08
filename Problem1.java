
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// two sum
import java.util.Arrays;
import java.util.HashMap;

class Main {
    public static int[] twoSum(int[] nums, int target) {

        // I am using map ds because search operation will be done in O(1) time
        HashMap<Integer, Integer> map = new HashMap<>();

        // first put all the nums and its index in hashmap
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // second we check that if complement of the element is available in the map
        // then we return its index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // here also I am checking that complement data's index is not same as our num
            // data as we cannot use repeat data to get our target
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }

        // if data is not found then we return -1 -1;
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}