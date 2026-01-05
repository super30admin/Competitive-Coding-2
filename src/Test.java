import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        // 0/1 Knapsack Tests
        Problem1 ks = new Problem1();

        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        int expectedKnapsack = 220;

        System.out.println(ks.maxValueRecursive(values, weights, W) == expectedKnapsack);
        System.out.println(ks.maxValueTopDown(values, weights, W) == expectedKnapsack);
        System.out.println(ks.maxValueBottomUp2D(values, weights, W) == expectedKnapsack);
        System.out.println(ks.maxValueBottomUp1D(values, weights, W) == expectedKnapsack);

        //Two Sum Tests
        Problem2 ts = new Problem2();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] res1 = ts.twoSum(nums1, target1);

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] res2 = ts.twoSum(nums2, target2);

        System.out.println(Arrays.equals(res1, new int[]{0, 1}));
        System.out.println(Arrays.equals(res2, new int[]{1, 2}));
    }
}
