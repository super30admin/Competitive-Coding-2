import java.util.*;
public class TwoSum{

    public static int[] twoSum(int[] nums, int target) {
        
        int[] ans = new int[2];

        if(nums==null || nums.length == 0)
        {
            return ans;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i], i);
        }

        for(int i =0;i<nums.length;i++)
        {
            int difference = target - nums[i];

            if(map.containsKey(difference) && map.get(difference)!=i)
            {
                ans[0]=i;
                ans[1]=map.get(difference);
                return ans;
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        int[] nums = {2,7,11,15};
        int target= 9;
       int[] ans = twoSum(nums, target);
       for(int i:ans)
       {
           System.out.print(i+" ");
       }
    }
}