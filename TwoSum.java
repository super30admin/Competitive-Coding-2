/*
Problem: https://leetcode.com/problems/two-sum/
Time complexity: O(n). We traverse the list containing nn elements only once. Each lookup in the table costs only O(1) time.
Space complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach

*/
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

              for (int i=0; i<nums.length;i++) {
          int current = nums[i];
          int x =  target - current;
                    if(map.containsKey(x)) {
              return new int[] {map.get(x), i };
          }
       map.put(nums[i],i);
      }
        return result;
        
    }
    
   public static void main(String args[]){
       int nums[] = {1,2,3,4,5,6,7};
       int target = 3;
       twoSum(nums,target);
      
       
   } 
}