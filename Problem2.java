import java.util.HashMap;

/*
Two Sum
approach: traverse through elements, check if target-curr exists in map, if yes, return, else add (curr, index) to map.
time: O(n)
space: O(n)
 */
public class Problem2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[]{-1, -1};

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return res;
    }
}