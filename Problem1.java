// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//Using hasing approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        int n = nums.length;
        int temp =0;
        for(int i =0; i<n ; i++){ // tc 0(n)
            temp = target - nums[i]; // 7
            if(map.containsKey(temp)){
                arr[0] = i;
                arr[1] = map.get(temp);
                return arr;
            }
            map.put(nums[i], i);
        }
        return arr;
    }
}