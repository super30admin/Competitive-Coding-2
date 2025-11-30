// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// created array to track the previously visited elements with index
// then checked if the subtraction of target and nums[i] in the prev tracked elements
// if there returned that index with the current index
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prev_visited_elements = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (prev_visited_elements.containsKey(complement)) {
                return new int[] {prev_visited_elements.get(complement), i};
            }
            prev_visited_elements.put(nums[i], i);
        }
        
        return new int[] {};
    }
}
