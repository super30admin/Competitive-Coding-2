/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/

//Time Complexity : O(n)
//Space Complexity: O(n)

public class Problem1 {

    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {

            if(map.containsKey(nums[target - nums[i]])) {
                res[0] = map.get(target - nums[i]);
                res[1] = nums[0];
            }

            map.put(nums[i], i);
        }
        return res;
    }
}