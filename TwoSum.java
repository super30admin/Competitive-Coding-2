// Time complexity = O(n)
// Space complexity = O(n)
// The approach is that we are storing the {key: value} pair as {nums-target: index}
// The 2nd approach is that x+y = target. 
//so if we store the target-x, and y == target-x, we know we hit the jackpot.

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++) {
            if(map.containsKey(nums[i])) {
                return new int[]{i,map.get(nums[i])};
            }
            map.put(target-nums[i], i);
        }
        return new int[]{-1,-1};
    }
}