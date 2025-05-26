class TwoSum {
    /**
     * Brute force is nested iteration solution Time O(n^2) and space O(1)
     * In below solution finding the element which could form the pair with current element
     * to reach target is done in O(1) time improving on time complexity at cost of space complexity
     * Time O(n) Space O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookupMap = new HashMap<>();
        // [-10, 7, 8, 4, 5] target 12
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int anotherVal = target - val;

            if(lookupMap.containsKey(anotherVal)) {
                return new int[]{i, lookupMap.get(anotherVal)};
            }
            lookupMap.put(val, i);
        }
        return new int[]{};
    }
}