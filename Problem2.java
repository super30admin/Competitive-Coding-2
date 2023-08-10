// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the length of the given array

// Your code here along with comments explaining your approach
    //We maintain a hashmap to store the numbers and their indexes. While traversing the array, we also put the number and index in the hashmap.
    //At each iteration, we have a new required number that is "target-currentNumber" to look for.
    //If the required number is present, we return the current index and the index of the required number's index which can be found in O(1) time from the hashmap.

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int n = nums.length;
        int ans[] = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<n; i++)
        {
            int required = target-nums[i];
            if(map.containsKey(required))
            {
                ans[0] = map.get(required);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}