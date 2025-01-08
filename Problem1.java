


//Time Complexity :O(n)
//Space complexity :O(n)
class Solution {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> twonumbers = new HashMap<Integer, Integer>();
        int diff=0;

        for (int i=0;i<nums.length;i++) {
            diff = target-nums[i];
            if (twonumbers.containsKey(diff) && i!=twonumbers.get(diff)) {
                return new int[]{twonumbers.get(diff), i};
            } else {
                twonumbers.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
}
