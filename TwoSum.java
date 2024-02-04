// Time Complexity : O(n), where n is the length of the input 
// Space Complexity : O(n), where n is the length of the input

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = target - nums[i];
            if (map.containsKey(curr)) {
                return new int[] { map.get(curr), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        List<int[]> input = new ArrayList<>();
        List<Integer> target = new ArrayList<>();
        Collections.addAll(input, new int[] { 2, 7, 11, 15 }, new int[] { 3, 2, 4 }, new int[] { 3, 3 });
        Collections.addAll(target, 9, 6, 6);

        for (int i = 0; i < input.size(); i++) {
            System.out.println(Arrays.toString(twoSum(input.get(i), target.get(i))));
        }
    }
}