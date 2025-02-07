// Overall Time Complexity : O(n) . The n is number of items and m is the capacity  in the matrix.
// Overall Space Complexity : O(n) . The space complexity is the time take to store elements in the hashmap.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation


// This solution to two sum involves creating hashmap and storing the elements of the array along with their respective indices.
// Iterate over the input array and take the complement by subtracting the array element with the target.
// Check if the complement is present in the hashmap and return the indices if true.

import java.util.HashMap;
import java.util.Map;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i=0; i<nums.length;i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)&& map.get(comp)!=i){
                return new int[]{i,map.get(comp)};
            }
        }
        return new int[]{-1,-1};
}}


