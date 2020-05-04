// Time Complexity : O(n) where n is the number of elements in the array
// Space Complexity : O(n) to maintain a hashmap of values and indices
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I did a two pass initially. 
/* Your code here along with comments explaining your approach: While you parse the array, store the elements as keys and the index of the element
as their value. Check if target - element value in the array belongs as a key to hashmap, fetch those indices an keep it in result. 
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
     int[] result = new int[]{-1,-1};               // Cover if element is not found in hashmap
     int j = 0;   
     HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
     if(nums == null || nums.length == 0){
         return result;
     }
     for(int i = 0; i < nums.length;i++){
         if(store.containsKey((target-nums[i])))            // if target - k belongs to hashmap
         {result[0] = i;
          result[1] = store.get(target-nums[i]);}           // Fetching the indices of the elements at once.
         store.put(nums[i], i);                             // Store the elements anyways into hashmap 
     }
        return result;
        }
}