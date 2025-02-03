import java.util.Arrays;
import java.util.HashMap;

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO

public class TwoSum {
    public static void main(String[] args) {

//        int[] nums = new int[] {2,7,11,15};
//        int target = 9;

//        int[] nums = new int[] {3,2,4};
//        int target = 6;
//
        int[] nums = new int[] {3,3};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap();

        int[] output = new int[2];

        for(int i = 0; i < nums.length; i++) {

            int remainder = target - nums[i];
            if(map.containsKey(nums[i])) {
                output[0] = map.get(nums[i]);
                output[1] = i;

                return output;
            } else {
                map.put(remainder, i);
            }

        }

        return output;

    }

}
