// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :  NO

//Storing remaining value in HashMap as key
//For each element, checking in HashMap so that I can check whether it sumup to target
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< nums.length; i++){
            if(map.containsKey(nums[i]))
                return new int[] {map.get(nums[i]), i};
            int remainingVal = target - nums[i];
            map.put(remainingVal, i);
        }
        return new int[2];
    }
}
