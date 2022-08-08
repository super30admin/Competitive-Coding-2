// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0 ; i<nums.length; i++){
            hm.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            int comp = target - nums[i];
            if(hm.containsKey(comp) && hm.get(comp) != i){
                return new int[]{i, hm.get(comp)};
            }
        }
        return null;
    }
}