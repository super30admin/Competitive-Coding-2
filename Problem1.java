/*
Run time complexity - O(N) where N is the number of elements in the array. One pass
Space complexity - O(N) where N is the number of elements in the array to store the array in the hashmap.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
     
    if(nums.length<2)
        return new int[]{-1,-1};
    HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
    for(int i=0;i<nums.length;i++)
    {
        int val1=target-nums[i];
        if(map.containsKey(val1))
        {
            int j=map.get(val1); // if the value is present, then look for the target-current_num will give the index of the other number
            return new int[]{i,j};
        }
        else
        {
            map.put(nums[i],i); // If the value is not present in hashmap, then put into the map for future reference
        }
    }
        
       return new int[]{-1,-1}; 
    }
}
