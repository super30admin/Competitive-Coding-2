// Time Complexity :o(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :yes at some cases but revtified.


// Your code here along with comments explaining your approach:- checking target-array each value in hashmap as getting from key is o(1)






class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for(int i = 1; i < nums.length; ++i)
        {
            if(map.containsKey(target - nums[i]))
            {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}