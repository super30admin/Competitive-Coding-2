Time Complexity- O(n)
Space Complexity-O(n)
Executed on Leetcode - Yes

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return new int[]{};

     HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i]))
                return new int[]{i,hm.get(target-nums[i])};
            hm.put(nums[i],i);
        }
             return new int[]{};
    }
}