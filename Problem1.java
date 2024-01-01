//Time complexity: O(n)
//Space complexity: O(n)
class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap();
        if(nums == null || nums.length == 0) {
             return new int[] {-1,-1};
        }
        for(int i=0; i<nums.length; i++) {
            if(numsMap.containsKey(nums[i])) {
                return new int[] {i,numsMap.get(nums[i])};
            }
            numsMap.put(target-nums[i], i);
        }
        return new int[] {-1,-1};
    }
}
