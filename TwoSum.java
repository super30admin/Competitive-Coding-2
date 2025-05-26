import java.util.*;

public class TwoSum {
    static  int[] findTarget(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sol = new int[2];

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {-1, -1};
    }
    public static void main(String[] args) {

        int[] nums ={2, 11, 15, 7};
        int target = 9;
        System.out.println("Indices where the numbers that sums up to target are " + Arrays.toString( findTarget(nums, target)));

    }
}
