// T.C- O(N)
//S.C- O(N)

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{};
        }
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0; i< nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i=0; i< nums.length;i++){
            int comp= target- nums[i];
            if(map.containsKey(comp) && map.get(comp) != i){
                return new int[]{i, map.get(comp)};
            }
        }
        return null;
    }
}