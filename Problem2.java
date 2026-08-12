
//Approach: The idea is to take a hashmap and store index and (target-currElement), while adding elements,
// check if the difference between target and the current element already exists as a key in
//the hashmap, if it does exist that means the sum of the current element and the element present in the hashmap
// If so return the current index and the value of the hashmap with the key.

//Time Complexity : O(1)
//Space Complexity : O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        //Validate the inputs
        if (nums == null || nums.length == 0)
        {
            return new int[] {-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(target - nums[i]))
            {
                return new int[] {map.get(target-nums[i]), i};
            }
            else
            {
                map.put(nums[i], i);
            }
        }

        return new int[] {-1, 1};
    }
}