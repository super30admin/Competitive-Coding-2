class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> ele = new HashMap<>();
        for (int i = 0 ; i< nums.length; i++) {
            if (ele.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = ele.get(target-nums[i]);
            } else {
                ele.put(nums[i], i);
            }
        }

        return res;
    }
}