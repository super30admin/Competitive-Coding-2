// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.HashMap;
import java.util.Map;

/*
 * Create a hashmap and store elements and their index. If a complement is present in map then you have found the answer , else store that element and its index in map.
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] res=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                res[0]=i;
                res[1]=map.get(target-nums[i]);
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
}