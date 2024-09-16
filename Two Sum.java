// // Time Complexity : O(n) ; where n is length of nums array
// // Space Complexity : O(n) 

class Solution {
    public int[] twoSum(int[] nums, int target) {
    
    HashMap<Integer, Integer> map = new HashMap();
    for (int i=0; i<nums.length; i++){
        int match = target - nums[i];
    
        if(map.containsKey(match))
            return new int[] {map.get(match), i};
        
        map.put(nums[i],i);
    }  
        throw new IllegalArgumentException("No two sum solution");
   }
}
