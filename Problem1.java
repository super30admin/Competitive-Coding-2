// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int res[]=new int[2];

        int findEle=0;
        for(int i=0;i<nums.length;i++){
            findEle=target-nums[i];
            if(map.containsKey(findEle)){
                res[0]=i;
                res[1]=(int) map.get(findEle);
            }
            else
                map.put(nums[i], i);
        }
        return res;
    }
}
