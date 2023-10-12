import java.util.HashMap;
import java.util.Map;

import javax.swing.table.TableRowSorter;

// Two elements sum to target

//Time complexity: O(n)
//Space Complexity: O(n)

class Problem1 {

    public static void main(String[] args)
    {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("The sum exists at index " + result[0] + " and " + result[1]); 
        
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> record = new HashMap<>();
        
       for(int i=0;i<nums.length;i++){
       Integer compare = target -  nums[i];
           if(record.containsKey(compare)){
               result[0] = i;
               result[1] = record.get(compare);
           }
            else {
                record.put(nums[i],i);
            }
         }
         return result;
     }

}