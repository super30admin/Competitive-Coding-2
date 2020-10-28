/**LC-1
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. Create a hashmap to store num[i] and its index
 2. For each element,
    3. Check its complement exists in the hashmap
 */
package competitiveProg2;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){

            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
