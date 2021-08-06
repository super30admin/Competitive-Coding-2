/*
 * Time complexity: O(N) have to traverse array at least once.
 * Space Complexity: O(N) Worst case -takes all elements from array
 * 
 * */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> diffMap = new HashMap();
        
        for(int i=0; i<nums.length; i++){
            if(diffMap.containsKey(target-nums[i])){
                return new int[] {diffMap.get(target-nums[i]), i};
            }else{
                diffMap.put(target-nums[i],i);
                diffMap.put(nums[i],i); 
            }
        }
        
        return new int[] {-1,-1};
    }
}