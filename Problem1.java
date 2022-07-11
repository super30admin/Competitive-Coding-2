//Time Complexity: O(n).
//Space Complexity: O(n).


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sum = new HashMap<>();
        int rsum = 0;
        for(int i = 0; i < nums.length; i++){
            rsum = target - nums[i];
            if(sum.containsKey(rsum)){
                int first = sum.get(rsum);
                return new int[]{first, i};
            }
                
            else
            {
                sum.put(nums[i], i);
            }
        }
        
        return new int[] {-1, -1};
    }
}