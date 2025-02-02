// Interview Problem : Two elements sum to target

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only

/*
 * Here, I used hash map to store the value and its index. I tried to find if target-element at i is already present in the hashmap. If no add
 * element and its index, else return the index and index of the target-element index.
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }
            else{
                return new int[]{map.get(target-nums[i]),i};
            }
        }
        return new int[]{};
}
}
