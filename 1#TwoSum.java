// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Brute force will O(n2)
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }
    }
} */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>(); // hashmap to store value and index of array element

        for(int i = 0 ;i < nums.length;i++){ // iterate over array
            if(hm.containsKey(target - nums[i])) // if sum - current array value is present in hashmap 
                return new int[]{hm.get(target-nums[i]),i}; // return current index and index of the other array element
            hm.put(nums[i],i); // put array element value and index in hashmap
        }
        return new int[]{0,0}; //by default return {0,0}
    }
}