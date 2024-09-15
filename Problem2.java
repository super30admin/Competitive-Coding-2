// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*
 * Choose a hash map which checks if the number has a key within the map. 
 * If not, add target-nums[i] into the map. 
 * If key exists, add it into the result array.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length; 
        int res[] = new int[2];
        if(n == 0 || nums == null)
            return res;
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                res[0] = map.get(nums[i]);
                res[1] = i;
            }
            map.put(target-nums[i],i);
        }
        return res;
    }
}