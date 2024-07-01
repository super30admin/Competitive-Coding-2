// Two Sum 
//Time: O(n)
//Space: O(n)

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int []{i, map.get(target - nums[i])};
            }else{
                map.put(nums[i], i);
            }
        }
        return result;
    }
}