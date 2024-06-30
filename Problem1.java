// Two sum - Leetcode #1
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> hashmap = new HashMap<>();
    for(int i = 0; i<nums.length; i++) {
      if(hashmap.containsKey(target-nums[i])) {
        return new int[]{hashmap.get(target-nums[i]), i};
      }else {
        hashmap.put(nums[i], i);
      }
    }
    return new int[]{-1,-1};
  }
}