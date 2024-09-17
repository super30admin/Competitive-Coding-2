// Time Complexity : O(n) - worst case, where n is the number of elements in the array.
// Space Complexity : O(n) - hash map space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Check for the complements if it is already present in the hashmap return the indices, else, add the number along with its index.
// if the pair is not found, return -1,-1.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[0];
        Map<Integer,Integer> hmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int c=target-nums[i];
            System.out.println(c);
            if(hmap.containsKey(c)){
               return new int[] {hmap.get(c),i};
            }
            hmap.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}