// Time Complexity :O(n) n is length of nums
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Your code here along with comments explaining your approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){
                return new int[] {i,map.get(target-nums[i])};
            }
        }
        return null;
    }
}