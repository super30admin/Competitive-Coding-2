// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // map stores key= nums[i] , value= i
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int diff=0;
        for(int i=0;i<nums.length;i++)
        {
            diff=target-nums[i];
            // check if difference is present in hashmap
            if(map.containsKey(diff))
            {
                return new int[] {i, map.get(diff)};
            }
            else
                map.put(nums[i],i);
            
        }
        
        return new int[]{-1,-1};
        
    }
}