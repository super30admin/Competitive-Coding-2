import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    //Time Complexity O(n!)
//Space Complexity O(1)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] answer = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[i] + nums[j]) == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return new int[0];
    }

//Time Complexity O(n)
//Space Complexity O(n)

    public int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] matrix = {3, 2, 4};
        int[] result = twoSum.twoSum(matrix, 6);
        System.out.println("Final value " + Arrays.toString(result));
    }

}
