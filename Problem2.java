// Time Complexity : O(n) where n is the length of the input array
// Space Complexity : O(n) where n is the length of the input array
//Approach : Hashing

import java.util.HashMap;

public class Problem2 {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(arr[i], i);
        }

        return new int[] { -1, -1 }; // return -1, -1 if no solution found

    }

    public static void main(String[] args) {
        Problem2 problem = new Problem2();
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = problem.twoSum(arr, target);
        System.out.println("Two Sum Indices: " + result[0] + ", " + result[1]); // Output: Indices: 0, 1
    }
}