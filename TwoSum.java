//time - O(n)
//space - O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> support = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        //check if complement exists, if so return its index and current index
        //else add item and index
        for(int i = 0; i < nums.length; i++)
        {
            if(support.containsKey(target - nums[i]))
            {
                result[0] = support.get(target - nums[i]);
                result[1] = i;
            }
            else
            {
                support.put(nums[i], i);
            }
        }
        return result;
    }
}
