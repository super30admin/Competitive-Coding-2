// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length;i++){
            //take complement
            int complement = target - nums[i];
            //if complement is present we found the pair
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            else
                map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}