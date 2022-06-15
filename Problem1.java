// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Two Sum

class Solution {
    public int[] twoSum(int[] nums, int target) {

        if(nums.length == 0){
            return new int[0];
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];

            if(map.containsKey(diff)){
                if(i != map.get(diff)){
                    return new int[]{i, map.get(diff)};
                }
            }
        }
        return new int[]{-1,-1};
    }
}