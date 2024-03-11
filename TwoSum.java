import java.util.HashMap;

//tc = o(n)
//sc = o(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1,-1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);

        }
        return result;
    }
}