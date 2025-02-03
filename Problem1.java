// https://leetcode.com/problems/two-sum/
// Time: O(n)
// Complexity: O(n)

class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i], i);
            }else{
                res[0] = map.get(target-nums[i]);
                res[1] = i;
            }
        }
        return res;
    }
}