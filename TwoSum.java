class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // to store nums and its index;
        Map<Integer,Integer> map = new HashMap();
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        
        // to check if compliment exists and stores its and its index
        for(int i =0;i<nums.length;i++){
            
            int compliment = target-nums[i];
            
            if(map.containsKey(compliment) && map.get(compliment) != i){
                
                return new int[]{i,map.get(compliment)};
            }
        }
        
        return new int[]{-1,-1};
        
    }
}