
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int[] output = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = target - first;
            int index = binarySearch(second, nums, i + 1);
            System.out.println(index);
            if (index == -1) {
                continue;
            } else {
                output[0] = i;
                output[1] = index;
            }
        }
        return output;
    }

    private int binarySearch(int target, int[] nums, int start) {
        int low = start;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.twoSum(new int[] { 2, 7, 11, 15 }, 9));
    }
}
