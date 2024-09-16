/**
Time Complexity - O(N)
Space Complexity- O(N)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if(nums == null || nums.length == 0)
            return null;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};
            
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
