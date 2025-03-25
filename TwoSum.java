import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return new int[] {};

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int cmp = target - nums[i];
            if (map.containsKey(cmp)) {
                return new int[] { i, map.get(cmp) };
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}

//TC: O(n) as we traverse through the array
//SC: O(n) to store the nums and index in a HashMap