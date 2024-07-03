//Two Sum Mock Interview Question1
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++) {
            int findValue = target - nums[i];
            if(map.containsKey(findValue)) {
                return new int[]{i,map.get(findValue)};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};

    }
}