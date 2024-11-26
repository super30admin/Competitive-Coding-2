// Time Complexity : O(n) where n is length of input array
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//TwoSum
class Problem1 {
    public int[] twoSum(int[] nums, int target) {
                    int[] a = new int[2];

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i])) //Check if compliment exists in map
            {
                a[0] = i;
                a[1] = map.get(target-nums[i]);
            }
            else
            {
                map.put(nums[i],i); //Add number to hashmap along with its index
            }
        }
        return a;
}
    
}
