import java.util.*;
class Problem1{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp=new HashMap<>();
        
        int[] result=new int[2];
            
            for(int i=0; i<nums.length;i++)
            {
                if(mp.containsKey(target-nums[i]))
                {
                    
                    result[0]=mp.get(target-nums[i]);
                    result[1]=i;
                }
                else
                    mp.put(nums[i],i);
            }
        return result;
    }
}