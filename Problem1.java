// Time complexity: O(n)
// Space complexity: O(n)
//Approach: Create a value to index hashmap. Traverse the array
// if complement exists in the map, this is the answer; else store the value to index
// in the map.

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // traversing the nums and storing in map
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] { -1, -1 };
    }
}