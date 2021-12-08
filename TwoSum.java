import java.util.HashMap;

// TwoSum
// Time Complexity :O(n)
// Space Complexity : O(n)

public class TwoSum {
    
    public int[] twoSum(int nums[], int target)
    {
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};

        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length; i++)
        {
            int key = target - nums[i];
            if(map.containsKey(key))
            {
                return new int[]{map.get(key), i};
            }
            else
            {
                map.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};

    }
}