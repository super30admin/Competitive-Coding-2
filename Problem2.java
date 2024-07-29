//TC O(n)
//SC O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
int res[]=new int[2];
HashMap<Integer,Integer> m=new HashMap<>();
for(int i=0;i<nums.length;i++)
{
    int tar=target-nums[i];
    if(m.containsKey(tar))
    {
        res[0]=i;
        res[1]=m.get(tar);
        return res;
    }
    m.put(nums[i],i);
}
return new int[]{-1,-1};
    }
}