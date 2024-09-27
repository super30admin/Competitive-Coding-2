//Leetcode 1 - Two Sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
    //base case
        if(nums.length <2 || nums == null) return new int[] {-1,-1};
    
        // value,    idx
    HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i< nums.length ; i++)
        {
            int diff =0;
            diff = target - nums[i];
            if(map.containsKey(diff))
            {
                return new int[] {i, map.get(diff)};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1,-1};
       
    }
}

//TC- O(n) -- traversing through the array
//SC- O(n) -- nHashmap used