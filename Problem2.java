// Two Sum
// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this:  No
// Your code here along with comments explaining your approach: 

class Solution 
{
    
    public int[] twoSum(int[] nums, int target) 
    {
    HashMap<Integer,Integer> map=new HashMap<>();
int[] arr={0,0};
for (int i=0;i<nums.length;i++)
{
  //check if target-nums is already present

  if(map.containsKey(target-nums[i])) 
  {
arr[0]=i;
arr[1]=map.get(target-nums[i]);
return arr; 
  } 

else
{
map.put(nums[i],i);
}
}

return arr;
    }
}