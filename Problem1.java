//TC & SC : O(n)
    class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> hashMap = new HashMap<>();
    int l = nums.length;
    for (int i=0; i<l; i++) {
        int pairValue = target-nums[i];
        if (hashMap.containsKey(pairValue)) {
            return new int[]{i, hashMap.get(pairValue)};
        }

        if (!hashMap.containsKey(nums[i])) {
            hashMap.put(nums[i], i);
        }
    }
    return null;
    }
}