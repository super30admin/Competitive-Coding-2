// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
import java.util.*;

class TwoSumSolution {

  public static void main(String[] args){
    int[] nums = {2,7,11,15};
    int  target = 9;
    int[] output = twoSum(nums,target);
    System.out.printf("[ %d, %d ]\n",output[0],output[1]);
  }

  public static int[] twoSum(int[] nums, int target){
    if(nums.length == 0 ) return new int[0];

        HashMap<Integer,Integer> hMap = new HashMap<>();

        int[] output = new int[2];
        for(int i=0; i<nums.length ; i++){
            if(hMap.containsKey(target - nums[i])){
                output[0] = i;
                output[1] = hMap.get(target - nums[i]);
                return output;
            }else{
                hMap.put(nums[i],i);
            }
        }

        return output;
  }
}
