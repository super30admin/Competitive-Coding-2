// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No.
//Apprach is to find the complement of target and the current num and find if it already exist and at what index.
class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        HashMap<Integer,Integer> hMap = new HashMap<>();//key -> element , value ->index of the element.

        for(int i=0;i<nums.length;i++){
            int remainder = target - nums[i];
            if(hMap.containsKey(remainder)){
                return new int[]{i,hMap.get(remainder)};
            }
            hMap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}