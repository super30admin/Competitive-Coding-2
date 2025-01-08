// Approach: We maintain a mapping of each element to its index in a hashmap. For each element in the array, if
// (target - element) is already present in the hashmap, it means there are two numbers that sum up to the target, and we
// return their stored indices. Otherwise, we add the current element and its corresponding index to the hashmap. If no such
// pair is found, we return -1, -1 as the indices.
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class TwoSum {

    int[] twoSum(int[] arr, int target) {
        // element to index map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[] { map.get(target - arr[i]), i  };
            }
            map.put(arr[i], i);
        }
        return new int[] { -1, -1 };
    }
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] arr = { 10, 6, 5, 4, 3 };
        int target = 9;
        int[] idxs = ts.twoSum(arr, target);
        System.out.println("Indices of two elements that sum up to given target are: " + Arrays.toString(idxs));
    }
}