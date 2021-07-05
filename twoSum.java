// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if(nums == null || nums.length ==0)
            return new int[]{0,0};
        
        //nums[i], index
        Map<Integer, Integer> map = new HashMap<>();
        int index1=0, index2=0;
        
        for(int i=0; i<nums.length; i++){
            //check if the map contains the key
            if(map.containsKey(target - nums[i])){
                index1 = map.get(target - nums[i]);
                index2 = i;
            } else {
                map.put(nums[i], i);
            }
        }
        
        return new int[] {index1, index2};
    }
}