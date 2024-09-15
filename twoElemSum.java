import java.util.HashMap;
import java.util.Map;

class twoElemSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.add(nums[i],i);
        }
        for(int  i=0;i<nums.length;i++)
        {
            int complement=target-nums[i];
            if(map.contains(complement) && map[complement]!=i)
            {
                return int [] {i,map[complement]};
            }
        }
        return int [] {-1,-1};
    }

}