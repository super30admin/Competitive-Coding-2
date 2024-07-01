//TC --> O(n)
//SC --> O(n)

/*
2 sum problem solved using HashMap
 */
import java.util.*;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            //target = x+y
            int diff = target - nums[i];
            if (mp.containsKey(diff)) {
                res[0] = mp.get(diff);
                res[1] = i;
                break;

            }
            mp.put(nums[i], i);

        }//for
        return res;
    }
}
