// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the array
//Space Complexity: O(n) since we are using extra HashMap 

public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
          
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i], i);
            }
            else{
                return new int[]{i, map.get(target-nums[i])}; // if the difference is found, then we found the corresponding index
            }
        }
        return new int[]{-1, -1};
 }