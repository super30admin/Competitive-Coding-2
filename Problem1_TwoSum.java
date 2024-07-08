//TC: O(n)
//SC: O(n)
//Solved on leetcode: yes
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0 ;i<nums.length ;i++) {
            int key = target - nums[i];
            if(map.containsKey(nums[i])) { 
                res[0] = map.get(nums[i]);
                res[1] = i;
            } else {
                map.put(key, i);
            }
        }
        return res;
    }
}