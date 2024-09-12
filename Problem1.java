//Two Sum
//Time Complexity: O(n)
//Space Complexity: O(n)
//Executed on leetcode.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map=new HashMap<>();
        int comp = 0;
        int []out = new int[2];
        map.put(nums[0],0);
        for(int i=1;i<nums.length;i++)        //3,2,4
        {
            comp = target - nums[i];
            if(map.containsKey(comp) && i!=map.get(comp))	//Storing each value and it's index in hashmap.
            {
                out[0] = i;
                out[1] = map.get(comp);						//If hashmap contains the other element which can give target we return indices of both the numbers
                return out;									
            }
            else
            {
                map.put(nums[i],i);
            }
        }
        
        return out;
    }
}