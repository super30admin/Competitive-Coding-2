class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        int key;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
key=target-nums[i];
if(map.containsKey(key))
{
    result[0]=map.get(key);
    result[1]=i;
}
else
{
    map.put(nums[i],i);
}

        }
        return result;
        
    }
}