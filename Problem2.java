// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach: Create a hashmap For value:index. Iterate through the array and check if the complement i.e. target-element is present or not.
// If found return the index of the value in hashmap and the ith element.
// If not found then add i element with its index in the hashmap.


class Problem2{
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