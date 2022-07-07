// TC: O(N)
// SC: O(N)

class Solution {
    public int[] twoSum(int[] nums, int target) {
     
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int diff = target - nums[i];
            if(hm.containsKey(diff)) {
                return new int[] {hm.get(diff), i};
            } else {
                hm.put(nums[i], i);
            }
        }
     return new int[] {};
    }
}
