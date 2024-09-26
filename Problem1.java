class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0)
        {
            return new int[0];
        }
     
           if(nums==null || nums.length==0)
        {
            return new int[]{-1,-1};
        }
        
        Map<Integer, Integer> otherH = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            int nu = target - nums[i];
            if(otherH.containsKey(nu))
            {
                return new int[]{i, otherH.get(nu)};
            }
            else{
                otherH.put(nums[i] , i);
            }
        }
        return new int[]{-1,-1};
        
    }
}

//runtime: O(n)
//space: O(1) because we are just returning the array of 2 numbers all the time
