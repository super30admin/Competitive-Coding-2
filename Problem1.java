// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //intialize a hashmap 
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //traverse over the input array and keep adding key, value pairs in the hashmap with value and index
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        
        //again traverse over the array 
        for(int i = 0; i < nums.length; i++){
            //find the complement using target value and check if it already exists in the hashmap with another index value other than i.
            //If yes, return the index pair, else return {-1, -1}
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{-1,-1};
        
    }
}