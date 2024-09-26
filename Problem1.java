/*
This program uses a hash map to solve the problem. First, all the numbers in the array are used
as keys, and their indices are used as solutions. Then, we go over the array iteratively and 
subtract the currently chosen number from the target value, and lookup the remainder in the 
hash map. If the remainder exists, then we return the indices of both the current number and 
the remainder.

Problems with this code: None

Did this code run on leetcode: Yes
*/

class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        
        int startIndex = 0;
        int endIndex = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        
        for(int i = 0; i < nums.length; i++)
        {
            int rem = target - nums[i];
            //We also check that the remainder is not at the same index as the current number, incase the target is 2 times the current number
            //as we have to return different indices
            if(map.containsKey(rem) == true && map.get(rem) != i)
            {
                startIndex = i;
                endIndex = map.get(rem);
                break;
            }
        }
        
        return new int[] {startIndex, endIndex};
    }
}