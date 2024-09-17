import java.util.HashMap;
/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int diff = target - nums[i];
            if(hash.containsKey(diff)){
                return new int[] {hash.get(diff), i};
            }
            hash.put(nums[i],i);
        }
        return new int[]{};
    }
}