// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Use HashMap to solve in O(N) time
*/
class TwoSum{
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{};

        HashMap<Integer, Integer> hm= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{i,hm.get(target-nums[i])};
            }else{
                hm.put(nums[i],i);
            }
        }

        return new int[]{-1,-1};
    }
}
