//TC: O(n)
//SC: O(n)
//Approach: iterate over array, and maintain hashmap of array value, and it's index in a hashmap
// at every index, if target-value at array exists in hashmap, return indices of current index and the target-value's index

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(!map.containsKey(diff)){
                map.put(nums[i], i);
            }else {
                return new int[]{i, map.get(diff)};
            }

        }
        return new int[]{};
    }
}