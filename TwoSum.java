
//Technique:2 HashMap 2 Sum
//Time Complexity =  O(n)
//Space Complexity = O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
     if(nums == null || nums.length == 0 ) return new int[] {};
        
     HashMap<Integer, Integer> map = new HashMap<>(); //O(n)
   
     for(int i=0; i< nums.length ; i++){ //O(n)
           int diff = target - nums[i];
         
           if(map.containsKey(diff)){ 
                   return new int[] {map.get(diff), i};          
           }
           map.put(nums[i], i);
     } 
     return new int[] {-1,-1};
   }
}
