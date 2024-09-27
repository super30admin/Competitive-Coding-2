import java.util.HashMap;

class Problem2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        Problem2 solution = new Problem2();
        int[] result = solution.twoSum(nums, target);

        if (result[0] != -1 && result[1] != -1) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
            System.out.println("Numbers: " + nums[result[0]] + ", " + nums[result[1]]);
        } else {
            System.out.println("No two numbers found that add up to the target.");
        }
    }
}