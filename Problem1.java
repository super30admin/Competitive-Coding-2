// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Hash map is created with element and its index, each time the compliment is found
//the hash map fond its compliment's index and returns it.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int compliment = target - nums[i];
            if(map.get(compliment) != null){
               return new int[]{i, map.get(compliment)};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}