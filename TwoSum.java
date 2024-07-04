//time complexity 0(N) - iterating through input array to build hashmap
//space complexity O(N) - creating a new hashmap
import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
    int[] result = {0,0};
    HashMap<Integer, Integer> mp = new HashMap<>();
      for(int i=0; i<nums.length;i++){
        int diff = target - nums[i];
        if(mp.containsKey(diff)){
            result[0] = i;
            result[1] = mp.get(diff);
            return result;
        }
        mp.put(nums[i],i);
      }
      return result;
}

public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(obj.twoSum(nums, 9)));
        }
}