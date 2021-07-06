// Time complexity: O(N), where N is the length of nums array. 
// Space complexity: O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] r = new int[2];
        
        if(nums == null || nums.length == 0) {
            r[0] = -1;
            r[1] = -1;
            return r;
        }        
        
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            
            if(map.containsKey(target-nums[i])) {
                r[0] = map.get(target-nums[i]);
                r[1] = i;
                return r;
            }
            map.put(nums[i], i);
        }
        return r;
    }
}