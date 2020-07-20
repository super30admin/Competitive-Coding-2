// O(n)
// O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length<2) {
            return new int[2];
        }
 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}