// Time Complexity : The time complexity is O(n) where n is the length of the array.
// Space Complexity : The spave complexity is O(n) where n is the length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        int[] output = new int[2];

        for(int i=0;i<nums.length;i++){

            int val = target-nums[i];

            // If the other value is present in the array, return the output
            if(map.containsKey(val)){
                output[0] = map.get(val);
                output[1] = i;
                return output;
            }
            // Add the value and its index in the array
            else{
                map.put(nums[i],i);
            }
        }

        return output;
    }
}