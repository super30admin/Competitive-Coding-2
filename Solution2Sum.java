import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Approach
1)Used a hashmap to store the occurences of the numbers in array and also the index as value
2) Iterate over the hashMap and check for target-nums[i] which will check for other number in array as part of sum.
3) Once we find it, we return it as an array of 2 numbers with the first number and second number
*/


class Solution2Sum {
    public static int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> map = new HashMap();
        
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                return new int[]{map.get(target-nums[i]),i};
            }
            
            map.put(nums[i],i);
        }
        
        return new int[]{-1,-1};
    }


    public static void main(String[] args)
    {
        int[]nums = {2,7,11,15}; 
        int target = 9;
        int output[]=twoSum(nums, target);

        
            System.out.println(" first index "+output[0]+"   second index "+output[1]);
       
    }
}