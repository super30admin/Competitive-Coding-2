/*
Time Complexity: O(n)
Space Complexity: worst case --> O(n)
best case: O(1)
Average: O(n
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<=nums.length-1;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                return new int[] { map.get(target-nums[i]),i};
            }
            else
            {
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}

