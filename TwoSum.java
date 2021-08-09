
//https://leetcode.com/problems/two-sum/
/*
Time: O(n)
Space: O(n) for HashMap
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                result[0] = i;
                result[1] = map.get(complement);
            }

            map.put(nums[i], i);

        }

        return result;

    }

}
