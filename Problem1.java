// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();	// hashmap initialization
        
        for(int i = 0; i < nums.length; i++){		// traverse through the nums array
            int complement = target - nums[i];		// find the complement of the number by subtracting with the target
            
            if(map.containsKey(nums[i])){			// check if the complement is present
                int idx = map.get(nums[i]);			// get the index of it 
                return new int[] {idx, i};			// return the current index
            }else{
                map.put(complement,i);				// if not found, put the complement in the array along with the index
            }
        }
        return new int[] {-1,-1};					// default case, return -1,-1 if there's no match
    }
}