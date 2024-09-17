import java.util.HashMap;
//Time Complexity :o(n)
//Space Complexity : o(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        
        int[] array=new int[2];
        
        for(int i=0;i<nums.length;i++)
        {
            if(h.containsKey(target-nums[i]))
            {
                array[0]=h.get(target-nums[i]);
                array[1]=i;
            }
            else
            {
                h.put(nums[i],i);
            }
        }
        return array;
    }
}