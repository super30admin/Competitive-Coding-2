// TimeComplexity: O(n)
// SpaceComplexity: O(n)
// Explanation: I am iterating through the array and storing the elemnet in the hashmap with its index if the compliment is not found. If the compliment is found I am returning the compliment index and the current index.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
        
    }
}
