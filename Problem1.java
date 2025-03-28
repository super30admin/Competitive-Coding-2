// Time Complexity: O(N)
// Space Complexity: O(N)

// Approach:
// Iterate through the array while storing indices of elements in a HashMap.
// For each element, check if its complement (target - nums[i]) exists in the HashMap.
// If found, return indices; otherwise, continue storing elements.


import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] myArray = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int rem = target-nums[i];
            if(map.containsKey(rem))
            {
                myArray[0]= map.get(rem);
                myArray[1]= i;
                return myArray;
            }
            else
            {
                map.put(nums[i],i);
            }
        }
        return myArray;
    }
}