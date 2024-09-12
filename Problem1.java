Time Complexity: O(n) since we are traversing once through n elements and lookup is using Hash Map
Space Complexity: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
       if(nums == null || nums.length ==0) return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i< nums.length; i++)
        {
           int compliment = target - nums[i];
           if(!map.containsKey(compliment))
           {
               map.put(nums[i],i);
           }
            else{
                return new int[]{i, map.get(compliment)};
            }
        }
        
       throw new IllegalArgumentException("No two sum solution");
    }
   
}
