//twosum 

//Time Complexity : O(N)
//Space Complexity : O(N)
import java.util.*;

class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int a = target - nums[i];
            if(hmap.containsKey(a)){
                return new int[]{hmap.get(a), i};
            }
            hmap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}