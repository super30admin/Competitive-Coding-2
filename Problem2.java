import java.util.HashMap;
import java.util.Map;

class TwoSum{
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0 ;i < nums.length; i++){
            if(numMap.containsKey(target - nums[i])){
                return new int[] {i, numMap.get(target - nums[i]) };
            }else{
                numMap.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }


    public static void main(String[] args){
        System.out.println("Number of combinations : "+ twoSum(new int[]{2,7,11,15},  9));
        System.out.println("Number of combinations : "+ twoSum(new int[]{3,2,4},6));
    }
}