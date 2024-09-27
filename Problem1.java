// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> table = new HashMap<>();
        for(int i=0 ; i<nums.length; i++){
            table.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            int comp = target - nums[i];
            if(table.containsKey(comp) && table.get(comp) != i){
                return new int[]{i, table.get(comp)};
            }
        }
        return null;
    }
}
