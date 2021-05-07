import java.util.*;

class Problem1 {
    // Two Sum
    public static int[] two_sum(int[] nums, int target) {
        /*
         * Time Complexity: O(n)
         * Space Complexity: O(n)
         */
        int n = nums.length;
        // hashmap to track required num: index of num
        HashMap<Integer, Integer> d = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++){
            int diff = target - nums[i];
            // when we find required num, return along with saved num
            if (d.containsKey(nums[i]))
                return new int[] {nums[i], nums[d.get(nums[i])]};
            else
                d.put(diff, i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        System.out.println("Two Sum: " + Arrays.toString(two_sum(new int[] {2, 7, 11, 15}, 9)));
    }
}