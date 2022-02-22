/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] rv = new int[2];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
                
        for(int i=0; i<nums.length; i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                int comp_index = map.get(comp);
                if(comp_index!=i){
                    rv[0] = i;
                    rv[1] = comp_index;
                    break;
                }
            }
        }
        
        return rv;
    }
}
