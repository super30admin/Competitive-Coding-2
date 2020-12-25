/** Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
* TC O(N) SC O(N)
*
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        if (nums == null || nums.length == 0)
            return index;
        HashMap<Integer, Integer> sum = new HashMap<Integer, Integer>();
        
        for (int i = 0; i <nums.length; i++)  {
           int first = nums[i]; 
           int second = target - first;
           if (sum.containsKey(second) && (i != sum.get(second))) {
               index[0] = i;
               index[1] = sum.get(second);
           }
          sum.put(nums[i], i);
        }
        return index;
    }
}
