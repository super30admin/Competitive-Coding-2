//Time O(n)
//Space O(n)
//
class Problem1 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++)
        {
            int compliment=target-nums[i];
            if(map.containsKey(compliment)&&i!=map.get(compliment))
            {
                return new int[]{i,map.get(compliment)};
            }
        }
        return nums;
    }
}