import java.util.HashMap;

//Time Complexity: O(N)
//Space Complexity O(N)
//Leetcode: Yes
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }
        return null; //you can create an array first and then return the array as well
    }
}
