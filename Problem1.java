// TC: O(n)
// SC: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return ans;
    }
}