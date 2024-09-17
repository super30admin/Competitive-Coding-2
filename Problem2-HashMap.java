//Time Complexity: O(N)
//Space complexity: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int j = 0; j < nums.length; j++) {
            int key = target - nums[j];
            if(map.containsKey(key) && map.get(key) != j) {
                return new int[]{j, map.get(key)};
            }
        }
        return null;
    }
}