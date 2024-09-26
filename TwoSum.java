// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];// we calculate the difference between target and current number
            if(map.containsKey(diff)){//if map contains it, then it means the current index and map make the target
                return new int[]{map.get(diff),i};//so we return it
            }
            map.put(nums[i],i);//or we add to map
        }
        return null;
    }
}