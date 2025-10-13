// 1. Two Sum
// https://leetcode.com/problems/two-sum/description/

/**
 * Time Complexity: O(n) since we traverse entire array
 * Space Complexity: O(n) since in worst case we might store all elements in map
 */


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int ans[] = {-1, -1};

        for(int i = 0; i < nums.length ; i++){
            int diff = target - nums[i];

            if(map.containsKey(diff)){
                ans[0] = i;
                ans[1] = map.get(diff);
                return ans;
            }

            map.put(nums[i], i);
        }

        return ans;
    }
}