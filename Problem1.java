//TwoSum

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create a hashMap store all the values of array and their count
//Now run through the array and find complements in the hashMap
//If the complement exist take note of index and seach array for the complement value.
//Take care of the special cases where num * 2 = target.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        //HashSet<Integer> hs = new HashSet<>();
        int[] res = new int[2];
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i], 0)+1);  
        }
        for(int i = 0; i < nums.length; i++){
            int remains = target - nums[i];   
            if(hm.containsKey(remains)){
                if(target == remains*2 && !(hm.get(remains) > 1))
                    continue;
                else
                    start = i + 1;
                
                res[0] = i;
                break;
            }
        }
        for(int i = start; i < nums.length; i++){
            if((i != res[0]) && (nums[i] == (target - nums[res[0]]))){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}