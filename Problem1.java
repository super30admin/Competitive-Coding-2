import java.util.HashMap;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

class TwoSum {

  public static int[] search(int[] arr, int targetSum) {
    HashMap<Integer, Integer> nums = new HashMap<>(); // to store numbers and their indices
    for (int i = 0; i < arr.length; i++) {
      if (nums.containsKey(targetSum - arr[i]))
        return new int[] { nums.get(targetSum - arr[i]), i };
      else
        nums.put(arr[i], i); // put the number and its index in the map
    }
    return new int[] { -1, -1 }; // pair not found
  }

  public static void main(String[] args) {
    int[] result = TwoSum.search(new int[] { 2, 7, 11, 15 }, 9);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

  }
}