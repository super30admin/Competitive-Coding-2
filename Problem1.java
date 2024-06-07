class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int[] result = {map.get(nums[i]), i};
                return result;
            } else {
                int temp = target - nums[i];
                map.put(temp, i);
            }
        }
        return new int[1];
    }
}
