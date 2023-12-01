import java.util.HashMap;

//  Time Complexity: O(n)
//  Space Complexity: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i< nums.length; i++){
            if(map.containsKey(nums[i]))
            {
                int ans[] = {map.get(nums[i]), i};
                return ans;
            }
            map.put(target-nums[i], i);
        }
        return new int[0];
    }
}