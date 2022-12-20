// Time Complexity : O( n), n is the length of the array.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * keep track of the remaining sum (target-nums[i]) from target for every element in the array in a map with respect to the index.
 * If map has the complement return the indexes or else just the complement to the map. At the end if there is no pair return -1, -1
 * 
 */
class P
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++)
        {
            int sum = target - nums[i];

            if(map.containsKey(sum))
            {
                return new int[]{i, map.get(sum)};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }
}