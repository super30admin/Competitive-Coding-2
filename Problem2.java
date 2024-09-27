//Knapsack 0/1

// Time Complexity :O(n)
// Space Complexity :O(n)
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//useing the one pass hashmap
class Problem2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>  dict = new HashMap<>();
        for (int i = 0; i <nums.length;i++)
        {
            int diff = target-nums[i];
            if(dict.containsKey(diff))
            {
                return new int[]{dict.get(diff),i};
            }
            dict.put(nums[i],i);
        }
        return null;
        
    }
}