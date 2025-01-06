
/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * Approach: We iterate over the array and add num 
 * to Hashmap if not present. We also check if there exists
 * (target - num) in the HashMap. If it exists, we return those indices.
 */

import java.util.HashMap;
import java.util.Map;

class Problem1 {
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    result[0] = -1;
    result[1] = -1;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int difference = target - nums[i];
      if (map.containsKey(difference)) {
        result[0] = i;
        result[1] = map.get(difference);
      }
      map.put(nums[i], i);
    }
    return result;
  }
}