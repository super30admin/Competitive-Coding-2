// Time Complexity:O(N) ; N : length of array;
// Space Complexity: O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result={-1,-1};
        HashMap<Integer,Integer> hs= new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if (hs.containsKey(target - nums[i])){
                result[0]=i;
                result[1]=hs.get(target- nums[i]);
                return result;
            }
            hs.put(nums[i],i);
        }

        return result;
    }
}