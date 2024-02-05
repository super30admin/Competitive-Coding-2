// Problem Name: Interview Problem : Two elements sum to target

// Source Link: https://leetcode.com/problems/two-sum/

// Time Complexity : O(N), where N is the length of input array
// Space Complexity : O(N), where N is the length of input array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.HashMap;
import java.util.Map;

class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        // Map from value to index
        Map<Integer, Integer> idxMap = new HashMap<>();

        // For each of the elements, check if 'target-element' exists
        // If yes, we found our solution
        // else add current element to map along with index
        
        for(int i=0;i<nums.length;i++){ // O(n)
            int curr = target - nums[i];
            
            if(idxMap.containsKey(curr)){               // O(1)
                return new int[] {i, idxMap.get(curr)};
            }
            idxMap.put(nums[i], i);         // O(1)
        }

        return new int[] {-1,-1};        
    }
}