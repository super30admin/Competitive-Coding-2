// Two Sum

// Time Complexity : O(n)
// Space Complexity : O(n) since HashMap might have at max n-1 elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*

Approach: The optimized approach for this problem involves usage of a HashMap
to store the potential differences with the target. Example, if target is 9 and
our element is 7, we ideally want to look up whether 2 is present since 2 and 7
make a pair of elements that sum up to the target of 9. By using a HashMap,
we're making instant lookups instead of traversing the array again and again.

*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[] { m.get(target - nums[i]), i };
            }
            m.put(nums[i], i);
        }

        return null;
    }
}