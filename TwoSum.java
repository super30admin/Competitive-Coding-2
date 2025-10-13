import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> targetIndexMap = new HashMap<>();
        int[] result = new int[2];
        for (int i =0; i<nums.length;i++){
            int compliment = target - nums[i];
            if(targetIndexMap.containsKey(compliment)){
                result[0] = targetIndexMap.get(compliment);
                result[1] = i;
            }else{
                targetIndexMap.put(nums[i],i);
            }
        }
        return result;
    }
}