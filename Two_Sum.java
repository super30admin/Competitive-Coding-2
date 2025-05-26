// TC - O(n)
// SC - O(1)
// Approach - We are using a hashmap to map elements and its index. Check if map already contains the
// difference. If it does return the current index and index of element in map in new array 
// Else put the element in the map. 

import java.util.HashMap;

class Two_Sum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[] { i, map.get(diff) };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Two_Sum ts = new Two_Sum();
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        ts.twoSum(nums, target);
    }
}