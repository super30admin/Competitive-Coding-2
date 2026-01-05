import java.util.HashMap;
import java.util.Map;

public class Problem2{

    public int[] twoSum(int[] nums, int target) {
        // Time Complexity : O(N), N is number of elements in nums
        // Space Complexity : O(N)
        int [] result = new int[2];
        Map<Integer, Integer> pairs = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            Integer index = pairs.getOrDefault(complement, null);
            if( index == null){
                pairs.put(nums[i], i);
            }else {
                result[0] = index;
                result[1] = i;
            }
        }
        return result;
    }
}