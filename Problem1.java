// Time Complexity : O(n) n = number of element in array
// Space Complexity : O(n) using hashmap of size n
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

//TwoSum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1,-1};

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }

        for(int j=0; j<nums.length; j++){
            int remain = target - nums[j];

            if(map.containsKey(remain)) {
                if(map.get(remain) != j){
                    return new int[] {j, map.get(remain)};
                }
            }
        }

        return new int[] {-1,-1};
    }
}