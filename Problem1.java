/**
LeetCode Submitted : YES
Time Complexity : O(N)
Space Complexity : O(N)

Using Hashmap to store complememts of the number
**/


class Solution {
    public int[] twoSum(int[] nums, int target) {
 
        int[] output = new int[2];
        
        /*for(int i=0; i< nums.length; i++){
            for(int j = i; j< nums.length; j++){
                if((nums[i]+ nums[j]) == target){
                    output[0] = i;
                    output[1] = j;
                    break;
                }
            }
        }*/
        
        if(nums ==  null || nums.length < 1)
            return(output);
        
        Map<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0;i <nums.length;i++){
            int diff  = target - nums[i];
            
            if(hm.containsKey(diff)){
               output[0] = i;
               output[1] = hm.get(diff);
               break;
 
            }
            hm.put(nums[i],i);
            
        }
        
       /*for(int i = 0; i< nums.length; i++){
           int diff =  target - nums[i];
           if(hm.containsKey(diff))
           {
               output[0] = i;
               output[1] = hm.get(diff);
               break;
               
           }
       } */
        
        
        return output;
        
    }
}
