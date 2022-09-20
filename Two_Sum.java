//TC : O(n)
//SC : O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hMap = new HashMap<>();
        
        int[] result = new int[2];
        
        for(int i = 0; i < nums.length; i++) {
            if(!hMap.containsKey(nums[i]))
                hMap.put(nums[i],i);
        }
        
        for(int i = 0; i < nums.length; i++) {
            
            if(hMap.containsKey(target - nums[i]) && 
               hMap.get(target - nums[i]) != i) {
                result[0] = i;
                result[1] = hMap.get(target - nums[i]);
                break;
            }
            
        }
        
        //System.out.println(result[0])
        
        
        return result;
        
    }
}
