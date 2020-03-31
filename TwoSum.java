class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int a[]=new int[2];
        
        for(int i=0;i<nums.length;i++)
        {
            int temp =target-nums[i];
            if(map.containsKey(temp))
            {
                a[0]=map.get(temp);
                a[1]=i;
                break;
            }
            else
            {
                map.put(nums[i],i);
                
            }
            
            
            
        }
        return a;
    }
}