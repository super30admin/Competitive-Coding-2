// Two elements sum to target
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use a hashMap here. We store the value of element along with its index in hashmap. When we see for current value
   hashmap contains target - nums[i], we get the index of that element and return it.
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};

        HashMap<Integer, Integer> hMap = new HashMap<>();

        for(int i = 0; i < nums.length; ++i) {
            if(hMap.containsKey(target - nums[i])) 
                return new int[]{i, hMap.get(target - nums[i])};
            
            hMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = {2,7,11,15};
        System.out.println(s.twoSum(nums, 9)); // [0, 1]
    }
}