// TWO SUM - Hashing
// Time Complexity = O(N)
// Space Complecity = O(N)
// Code was Working
class Solution {
    public int[] twoSum(int[] nums, int target) {  
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            } else {
                map.put(nums[i] , i);
            }
        }
        return result;
    }
}
