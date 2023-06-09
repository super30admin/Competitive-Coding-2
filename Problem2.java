// TC: O(n)
// SC: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int arr [] = new int [2];
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                arr[0] = i;
                arr[1] = map.get(nums[i]);
            }
            map.put(target - nums[i], i);
        }

        return arr;
    }
}