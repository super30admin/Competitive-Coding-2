// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Traverse every element and check if(target-element) exists in array.
If found we have pairs. 
Else put number as key and index as value in HashMap.
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(target- nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;

                return ans;
            }
            else{
                map.put(nums[i] , i);
            }
        }

        return ans;
    }
} 
