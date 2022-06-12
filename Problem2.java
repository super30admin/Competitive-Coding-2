//Time Complexity: O(n) 
// Space Complexity:O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer , Integer> hmap = new HashMap();
        for(int i = 0;i<nums.length;i++){
            hmap.put(nums[i],i);
        }
        
        for(int i = 0;i<nums.length;i++){
            int diff = target-nums[i];
            if(hmap.containsKey(diff) && hmap.get(diff) != i) 
                return new int[] {i, hmap.get(diff)};
        }
        return nums;
    }
}