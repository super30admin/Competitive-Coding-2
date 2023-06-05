//Time complexity: O(n) where n is the length of the nums array
//space complexity: O(n) where n is the length of the nums array as we need to create a HashMap for n elements
import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] output = {-1, -1};
        for(int i =0; i< nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                output[0] = map.get(diff);
                output[1] = i;
                return output;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}