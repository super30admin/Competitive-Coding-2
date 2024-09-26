//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.*;
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++)
        {
            hmap.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            int compliment = target - nums[i];
            if(hmap.containsKey(compliment) && hmap.get(compliment) != i)
            {
                result[0] = i;
                result[1] = hmap.get(compliment);
            }
        }
        return result;
    }
}