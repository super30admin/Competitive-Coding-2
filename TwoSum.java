// Time Complexity: O(n)
// Space Complexity = O(n)

import java.util.HashMap;

class TwoSum{
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> difference = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(difference.containsKey(nums[i])){
                return new int[] {difference.get(nums[i]), i};
            }
            difference.put(target-nums[i], i);
        }
        return new int[] {};
    }
}