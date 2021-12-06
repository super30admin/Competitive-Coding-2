// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach
// We can see that target must be sum of two numbers in the array
// So if we can get the other number by taking the difference of the target and the number
// We will use Hashmap to store the values to get the index of where the other number is
// Hashmap will have number as key and the index as value

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] { map.get(temp), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}