//Time Complexity : O(n)
//Space Complexity : O(n)
//Did your code run on leetcode : yes
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
       int[] res = new int[2];
        
        for(int i = 0 ; i < nums.length;i++)
        {
            map.put(nums[i] , i);
        }
        
        for(int i = 0 ; i < nums.length; i++)
        {
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i)
            {
               res[0] = map.get(target - nums[i]);
                res[1] = i;
            }
        }
        return res;
    }
    
}
