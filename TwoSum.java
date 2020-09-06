import java.util.*;

//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap();
        int result[] = new int[2];

        for(int i = 0;i < nums.length; i++){
            int key = target - nums[i];
            if(map.containsKey(key)){
                result[0] = i;
                result[1] = map.get(key);
                return result;
            }else{
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
