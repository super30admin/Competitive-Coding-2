// Time Complexity : O(n)
// Space complexity: O(n)
// Problem Name: Interview Problem : Two elements sum to target
// Approach using HashMap - Iterating through the nums array, checking if complement (target- nums[i]) is in the map,
// if it available, returning complement and index from the map
// else adding nums[i], index to the map
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i< nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement),i};
            }else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}