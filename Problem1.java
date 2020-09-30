// Time Complexity :O(NlogN)
// Space Complexity : O(NlogN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Using hashmap to store the distinct elements and find the difference between the target value and looking for it.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        int[] arr = new int[2];
        int diff = 0;
        arr[0] = -1;
        arr[1] = -1;
        hmap.put(nums[0],0);
        for(int i = 1; i < nums.length; i++){
            diff = target - nums[i];
            if(hmap.containsKey(diff)){
               arr[1] = i;
                arr[0] = hmap.get(diff);
                return arr;
            }
            else {
                hmap.put(nums[i], i);
            }
        }
        return arr;
    }
}
