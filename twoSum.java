package CompetitiveCoding2;

import java.util.HashMap;

public class twoSum {
    /*
    Brute Force
        Time Complexity: O(n ^ 2)
        Space Complexity: O(1)
     */

    public int[] twoSumBruteForce(int[] nums, int target) {
        for(int i = 0 ; i < nums.length - 1; i++) {
            for(int j = i + 1 ; j < nums.length ; j++) {
                int temp = nums[i] + nums[j];
                if(temp == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /*
    Two Pass HashMap
        Time Complexity: O(2n) ---> O(n)
        Space Complexity: O(n)
     */
    public int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0 ; i < nums.length ; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp) && map.get(temp) != i) {
                return new int[]{map.get(temp), i};
            }
        }
        return new int[]{-1, -1};
    }

    /*
    One Pass HashMap
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public int[] twoSumHashMap1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

    }
}
