/*
 *  Time Complexity: O(N) where N is the length of nums array.
 *  Space Complexity: O(N) Sice we create a HashMap to store all the possible remaining amounts. 
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : Design the approach to hold the min element.
 *
 *  Explanation: Create a HashMap which stores the key which is the remaining amount(target-nums[i]) and the value would be the index of this element(i). Every time in the loop we check if that element is present in the map. If present we return the current index and the index stored in the map. 
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) return new int[]{map.get(nums[i]),i};
            map.put(target-nums[i], i);
        }
        return new int[]{};
     }
}
