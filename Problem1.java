/**
Problem: two - sum: https://leetcode.com/problems/two-sum/
TC: O(n)
SC: O(n)
*/
class Solution {
    HashMap<Integer, Integer> intIndexMap = new HashMap<>();
    
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[] {-1, -1};
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if (intIndexMap.containsKey(diff)) {
                res[0] = intIndexMap.get(diff);
                res[1] = i;
                return res;
            }
            intIndexMap.put(nums[i], i);
        }
        return res;
    }
}