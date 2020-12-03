// Time Complexity - O(N), N is the number of elements in nums[]
// Space Complexity - O(N)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> hmap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int compl = target - nums[i];
            if(hmap.containsKey(compl) && hmap.get(compl) != i) {
                return new int[] {i, hmap.get(compl)};
            }
            hmap.put(nums[i], i);
        }
        
        return new int[] {-1, -1};
        
    }
}