class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap <Integer,Integer> hashMap = new HashMap<>();
        int sum;
        for(int i=0;i<n;i++)
        {   int complement = target - nums[i];
         
            if(hashMap.containsKey(nums[i]))
            {
               if(target == 2*nums[i])
               {
                   return new int[]{i,hashMap.get(nums[i])};
               }
            }
         if(hashMap.containsKey(complement))
            {
               
                   return new int[]{i,hashMap.get(complement)};
              
            }
            hashMap.put(nums[i],i);
            
            
        }
         
        
        return new int[]{-1,-1};
        
    }
}