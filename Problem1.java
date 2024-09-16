//Time Complexity : O(n), where n is number of elements in the array
//Space Complexity : O(n)
//Did this run on leetcode : yes
//Brief explanation about your approach  :
// Use one pass to put all elements in an hashmap
//use 2nd pass to check if compliment exits for a number, target-nums[i]

class Solution {
    public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    return new int[] {-1,-1};    
}
}