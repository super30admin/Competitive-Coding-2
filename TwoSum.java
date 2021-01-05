// TC: O(N) - N is the no. of elements of nums array
// SC: O(N) - N is the no. of elements of nums array
// Did it run successfully on Lettcode? : Yes

class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
       for ( int i = 0; i < nums.length; i++)
       {
           int complement =  target - nums[i];
           if (map.containsKey(complement))
           {
               return new int[]{i, map.get(complement)};
           }
           else
            map.put(nums[i], i);
       }
      throw new IllegalArgumentException("No two sum exists");
    }
}
