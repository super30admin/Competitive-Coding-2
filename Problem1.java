//TWO SUM
// Time Complexity :O(N) N = length of nums array(We would had to traverse
// until the last element if the second number is at the end).
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
//1. We take a HashMap to store the index and the value of the numbers that add up to the target.
//2. We traverse through the array and if the diference between the number and the target is in the HashMap. 
//If no then we add in the HashMap.
//3. If it contains the difference in the HashMap then store the current number's index and the difference number's index.


// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int res[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;

    }
}