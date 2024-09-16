// Time complexity: O(n)
//Space complexity: O(n)
//Step 1 creating a hashmap which contains the difference between the current value and target.
//Step2 I we encouunter the same value in map , we have found the pair required.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                return new int[]{map.get(nums[i]),i};
            }
            else
                map.put(target-nums[i],i);
        }
        return new int[]{-1,-1};
    }
}