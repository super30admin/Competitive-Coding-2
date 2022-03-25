// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            if(hmap.containsKey(target - nums[i])) {
                int index = hmap.get(target - nums[i]);
                return new int[]{index,i};
            } else {
                hmap.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}