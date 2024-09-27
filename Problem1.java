class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> mp= new HashMap<>();
        
        //time: 0(N)
        //Space: 0(N)
        
       // int[] res= new int[2];
        //iterate through the array:
        
        for(int i=0; i<nums.length; i++){
            
            //check the compliment in the map
            
            if(!mp.containsKey(target-nums[i])){
                mp.put(nums[i],i);
              
            }
            
            else
                return new int[]{i, mp.get(target-nums[i])};
                
        }
        
        return new int[]{-1,-1};
        
        
        
    }
}