// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Check if the result of target- nums[i] is already present in the hashmap 
//if yes return i, hashmap.get(target-nums[i]) 
//else store nums[i] as key and i as value

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{i,hm.get(target-nums[i])};
            }else{
                hm.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}