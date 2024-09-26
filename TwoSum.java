import java.util.HashMap;
// Time Complexity : O(n)
// Space Complexity : O(n)


public class TwoSum {
    public int[] findTarget(int[] arr,int target)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
         int[] output={-1,-1};
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(target-arr[i]))
            {
               output[0]=map.get(target-arr[i]);
               output[1]=i; 
            }
            else{
                map.put(arr[i],i);
            }
        }
        
        return new int[]{-1,-1};
    }

   
    public int[] twoSum(int[] nums, int target) {
        
       int[] output= findTarget(nums,target);
        
        return output;
    }
}
