//Time complexity: O(n) where n is the no. of elements
//Space complexity: O(n)
public class Solution {
   static int[] twoSum(int[]nums, int target) {
       int result[] = new int[2];
       HashMap<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
           int num = nums[i];
           int difference = target - nums[i];
           if (map.containsKey(difference)) {   
               result[0] = map.get(difference);
               result[1] = i;               
               break;              
               }
                map.put(nums[i], i);
           }       
       return result;
   }
    public static void main(String[] args) {
        int[] nums = {2,4,6,7,11,15};
        int target = 13; 
        int result[] = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]); 
    }
}