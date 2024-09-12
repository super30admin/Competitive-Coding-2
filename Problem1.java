
// Time complexity : O(n). 
// Space complexity : O(n). Used one hashmap, which stores at most n elements


import java.util.Arrays;
import java.util.HashMap;

public static class Solution {

    public static int[] twoSum(int[] nums, int target) {

     HashMap<Integer,Integer> map = new HashMap<>();
    

     for(int i=0; i <= nums.length -1; i++)

     {
          int differ = target - nums[i];
          
          
          if(map.containsKey(differ)){
              int remainVal = map.get(differ);
              return new int[] {remainVal, i };
          }
         map.put(nums[i], i);

     }

     

     return new int[] {-1,-1};


    }

    public static void main(String []args){
    
  int[] nums = new int[]{2,7,11,15};
  
  int[] result;

  result = twoSum(nums, 27);
  
  System.out.println(Arrays.toString(result));


}
}