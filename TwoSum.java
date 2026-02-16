// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
I would take a map of integers and iterate the input array. During iteration, if complement/difference of
the target and incoming array element value already exists in the map, it means, we already recorded the
associated value to make the sum inside the map.So,we fetch and return that value(index) and
index of i. If not, record the first occurence of that nums[i] and its index.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(sumMap.containsKey(diff))
                return new int[]{i,sumMap.get(diff)};
            sumMap.put(nums[i], i);
        }
        return new int[]{};
    }
}