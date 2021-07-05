import java.util.*;
class TwoSum {
public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
              int complement = target-nums[i];
              if(map.containsKey(complement)){
                  return new int[]{i,map.get(complement)};
                 }else{
                     map.put(nums[i],i);
                }
        }
          return new int[]{-1,-1};
        }
        public static void main(String[] args){
           TwoSum t = new TwoSum();
           int [] nums = {2,7,1,90};
           int target = 9;
        }
}