//Time Complexity = O(n)
//Space Complexity = O(n) // Worst
// Does it run on LeetCode successfully? : Yes
// Any difficulties: No as such. It seems easy problem. In an interview, I got muffled though due to stressful situation.

/*
Keep adding element along with its index from nums array to map. At every iteration first check whether target - current element exists or not.
If exist then current index and complement element's index stores as a value in Map are the pair's indices.

If we do not find any pair then return -1, -1

 */

import java.util.Map;
import java.util.HashMap;
public class TwoSum {
        public int[] twoSum(int[] nums, int target) {
            if(nums == null || nums.length == 0) return new int[]{-1,-1};
            int n = nums.length;
            Map<Integer,Integer> map = new HashMap<>();

            for(int i=0; i<n; i++){
                if(!map.containsKey(target - nums[i])){
                    map.put(nums[i], i);
                }else{
                    return new int[] { map.get(target-nums[i]), i }; //Only one valid solutions
                }
            }
            return new int[]{-1,-1};
        }
}