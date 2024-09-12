//Time o(n)
//space o(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int cum = target - nums[i];
            if(map.containsKey(cum))
            {
                res[0] = i;
                res[1] = map.get(cum);
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}