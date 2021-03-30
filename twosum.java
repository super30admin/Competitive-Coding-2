/*Time Complexity: O(n)
Space Complexity : O(n)
*/
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        //iterate through the array
        for(int i=0;i<nums.length;i++){
            //check if map contains the element if so, then return the element from the map and its index
            if(hashmap.containsKey(nums[i])){
                return new int[] {hashmap.get(nums[i]),i};
            }
            //otherwise, calculate the difference between the target and the ith element and add it to hashmap with value as the index
            int comp = target - nums[i];
            hashmap.put(comp,i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}