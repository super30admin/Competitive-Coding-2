//Time Complexity: O(n)
//Space Complexity: O(n)
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSumProblem(int[] nums, int targetSum){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[]{};
        for(int i=0; i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(targetSum-nums[i], i);
            }
            else{
                result = new int[]{map.get(nums[i]), i};
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5};
        int targetSum = 5;
        int[] result =  twoSumProblem(nums, targetSum);
        System.out.println(Arrays.toString(result));
    }
}