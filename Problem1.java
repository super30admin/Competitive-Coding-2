// Time Complexity : O(n) n is the length of the array  
// Space Complexity : O(n) for using HashMap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

//The idea is to store the element in the hashmap. when we encounter an element we will check if the complement is present in the hashmap, if yes we will return the current index and the value of the complement key(index of the complement).
//If no complement is found, the element is added to the hashmap.

class Solution {
    public int[] twoSum(int[] nums, int target) {
    if(nums.length==0) return new int[]{-1,-1};
    HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{i,map.get(complement)};
            }
            map.put(nums[i],i);
            
        }
        return new int[]{-1,-1};
}
}