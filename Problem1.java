class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i;
        for( i=0;i<n;i++)
        {
            map.put(nums[i],i);
        }
        int j=0;
        for(i=0;i<n;i++)
        {
            int value=target-nums[i];
            
            if(map.containsKey(value))
            {
                
                if(map.get(value)==i)
                    continue;
                
                j=map.get(value);
                break;
            }
        }
        
        return new int[]{i,j};
        
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
