
// Time Complexity: O(n)

//Space Complexity: O(1)

public class FindMissingNumber {

    public static int findMissing(int[] nums) {
        int n = nums.length + 1;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 6, 7, 8};
        System.out.println("Missing number: " + findMissing(arr1));

    }
}
