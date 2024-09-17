/**
 * TC - O(n) where n is length of nums
 * SC - O(n) where n is length of nums
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> diffIndexMap = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            if (diffIndexMap.containsKey(nums[i])) {
                return new int[] {i, diffIndexMap.get(nums[i])};
            } else {
                diffIndexMap.put(target - nums[i], i);
            }
        }

        return new int[] {-1,-1};
    }
}