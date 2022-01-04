//Two sum


//Time complexity : O(N)
//Space complexity: O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int cur = target - nums[i];
            if (map.containsKey(cur)) {
                return new int[]{map.get(cur), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
