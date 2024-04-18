
public class Problem1 {
   
    // using hahsmap
    // Space complexcity: O(n)
    // Time complexcity: O(n)
    public  int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] { -1, -1 };
    }

    // using HashSet
    // Space complexcity: O(n)
    // Time complexcity: O(n)
    public static int[] twoSumUsingHashset(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (set.contains(val)) {
                result[0] = i;
            }
            set.add(nums[i]);

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target - nums[result[0]] && result[0] != i) {
                result[1] = i;

            }
        }

        return result;
    }
}
