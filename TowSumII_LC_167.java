/***
 * Did this code successfully run on Leetcode :  Yes
 Any problem you faced while coding this :  No
 Approach 1: Brute force  Time complexity O(N^2), Space C0mplexity - O(1)
 Approach 2: Two pointer  Time complexity O(N), Space Complexity - O(1)
 ***/
public class TowSumII_LC_167 {
    public int[] twoSumTwoPointer(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        int sum = 0;
        while(start <= end) {
            sum = numbers[start] + numbers[end]; // 17
            if(sum == target) {
                return new int[]{start+1, end +1};
            } else if (target < sum) { //shift to left side
                end--;
            } else {
                start++;
            }
        }

        return new int[] {-1, -1};

    }
    public int[] twoSumTwoPointerBruteForce(int[] numbers, int target) {
        int len = numbers.length;
        for(int i = 0; i<len; i++){
            for(int j = i+1; j < len; j++){
                if(numbers[i] + numbers[j] == target){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[] {-1, -1};
    }
}