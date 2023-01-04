// TC = O(N)
// SC = O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // null
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        // adding the elements
        for(int i = 0; i < nums.length; i++) map.put(nums[i], i);
        // pay attention to the conditions in the question
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // checking for the ecistence of complement and cheking if it is not the same element
            if(map.containsKey(complement) && map.get(complement) != i)
                return new int[] {i, map.get(complement)};
        }
        return new int[] {-1, -1};
    }
}