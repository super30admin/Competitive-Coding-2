// Time - O(N)
// Space - O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i< nums.length ;i++){
            int compliment = target - nums[i];
            if(map.containsKey(compliment)){
                 return new int[] { i, map.get(compliment) };
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
