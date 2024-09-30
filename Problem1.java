// TC O(n)
//SC o(n)
// Run on leetcode yes

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> iMap = new HashMap();
    int[] op = new int[2];


        for(int i = 0; i < nums.length ; i ++) {
            int j = target-nums[i];
            if(iMap.containsKey(j)) {
                //op[0] = i;
                //op[1] = iMap.get(j);
                return new int[]{i, iMap.get(j)};
            } else {
                iMap.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
        
    }
}
