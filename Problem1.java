// Time Compelxity : O(N) //N = no of elements in the array
// Space Compelxity : O(N) // HashMap takes O(N) space

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length<1) return new int[]{};
        
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            hm.put(nums[i],i);
        }
        
        
        for(int i =0; i<nums.length; i++){
            if(hm.containsKey(target-nums[i]) && hm.get(target-nums[i]) != i){
                return new int[]{i,hm.get(target-nums[i])};
            }
        }
        return new int[]{};
    }
}