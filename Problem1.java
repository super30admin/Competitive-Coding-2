/*
Time Complexity -> O(N)
Space Complexity -> O(N)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[] { 0, 0 };
        }
        HashMap<Integer, Integer> hashMapp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (hashMapp.containsKey(nums[i])) {
                return new int[] { hashMapp.get(nums[i]), i };
            } else {
                hashMapp.put(diff, i);
            }
        }
        return new int[] { 0, 0 };
    }
}