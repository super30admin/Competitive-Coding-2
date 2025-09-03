// Time Complexity : O(n) where n is number of items
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Using hashmap to keep track if the complement sum exists in the map. If it does, we return the current index and the complement's index
 */
class Problem1{
    public void twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsByIndex = new HashMap<>();
        for (int i = 0; i < nums.length;i ++) {
            int complement = target - nums[i];
            if (numsByIndex.containsKey(complement)) {
                return new int[] {i, numsByIndex.get(complement)};
            }

            numsByIndex.put(nums[i], i);
        }

        //unreachable
        return new int[] {-1,-1};

    }
}