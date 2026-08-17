class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diffIndex = new HashMap<>();
        for(int i =0; i< nums.length; i++) {
            int diff = target - nums[i];
            if(diffIndex.containsKey(diff)) {
             int res = diffIndex.get(diff);
             return new int[]{i, res};
            } else {
                diffIndex.put(nums[i], i);
            }

        }
        return new int[]{-1, -1};
    }
}