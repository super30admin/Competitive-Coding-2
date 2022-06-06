/* Time Complexity: O(n) 	
 * Space Complexity:O(n)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int resultArray[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.get(complement) != null) {
                
                resultArray[0] = map.get(complement);
                resultArray[1] = i;
            } else {
                map.put(nums[i],i);
            }
            
        }
        
        return resultArray;
        
    }
}