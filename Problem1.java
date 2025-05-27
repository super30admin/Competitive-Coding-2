//Two sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            int remainderSum = target - nums[i];
            if(map.containsKey(remainderSum)){
                res[0] = map.get(remainderSum);
                res[1] = i;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
}