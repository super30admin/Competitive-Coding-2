// Time Complexity : DP: O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : No

/**
 * Iterate over the array, Find the complement of current element+target in the hashset. If found, then we have a pair of twoSum. Add the current element to the hashset to maintain
 * all the previous elements. These elements will be used later to find the two sum with the current element
 */

import java.util.*;
class Problem1 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 10, 14, 15};
        int target = 12;
        List<List<Integer>> result = new ArrayList<>();
        twoSum(arr, target, result);

        System.out.println(result);;
    }

    private static void twoSum(int[] arr, int target, List<List<Integer>> result) {

        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr.length; i++) {
            int complement = target-arr[i];
            if(set.contains(complement)) {
                result.add(Arrays.asList(complement, arr[i]));
                while(i+1 < arr.length && arr[i] == arr[i+1])
                    i++;
            }
            set.add(arr[i]);
        }
    }
}