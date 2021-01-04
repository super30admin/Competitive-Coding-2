// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Notes: Calculate the complement of the current element of array with the target value, and check if the complement exists in the Hashmap, if not found, then add (complement, index) pair, else return the index of the complement and current element

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        
        if(nums == null || nums.length == 1) return res;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length ; i++){

            int difference = target - nums[i];
            
            if(map.get(nums[i]) == null){
                map.put(difference , i);
            } else {
                res[0] = map.get(nums[i]);
                res[1] = i;

                return res;
            }
        }
        
        return res;
    }
}