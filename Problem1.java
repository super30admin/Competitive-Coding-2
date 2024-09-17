// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * For every element we need to see if (target - element) exists in array or not.
 * For this we use a HashMap as with HashMap lookup will be done in O(1) time.
 * For each element we check if HashMap has an try for (target - element). If yes, we found our pairs
 * Else we add an entry in HashMap with current number as key and its index as value.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(target- nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                
                return ans;
            }
            else{
                map.put(nums[i] , i);
            }
        }
        
        return ans;
    }
}