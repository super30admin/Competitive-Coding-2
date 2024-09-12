
// Time Complexity : O(n)  --> One for loop
// Space Complexity : O(n)  --> HashMap Storage
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 
// Your code here along with comments explaining your approach

import java.util.HashMap;
class Problem1 {
    public int[] twoSum(int[] nums, int target)
        {
            if(nums==null || nums.length==0){
                return new int[] {1,-1};
            }

            HashMap<Integer, Integer> sMap=new HashMap<>();
            for(int i=0;i<nums.length-1;i++){
                if(!sMap.containsKey(target-nums[i])){
                        sMap.put(nums[i], i);
                }
                else{
                    return new int[] {sMap.get(target-nums[i]),i};
                }

            }
                      
        return new int[] {1,-1};
    }

}
