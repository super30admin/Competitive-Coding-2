/*TC - O (N) - one iteration on  the input array
 * SC - O(N) - Hashmap of worst case size  - N
 * Ran on leetcode - yes
 * */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < nums.length; i++){
            if (map.containsKey(target-nums[i])){
		    // if the comlement is already present in gashmap, return the indices - 2) saved as value for complement 1) current index
                return new int[]{i, map.get(target-nums[i])};
            }
	    // store the index of the element seen
            map.put(nums[i], i);
        }
        
        return new int[]{};
    }
}



