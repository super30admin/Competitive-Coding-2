/**
 * Time Complexity: O(n) where n = size of nums
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[]{-1,-1};
        if(nums==null || nums.length  == 0) return arr;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                arr[0] = i;
                arr[1] = map.get(target-nums[i]);
                return arr;
            }
            map.put(nums[i],i);
        }
        return arr;
    } 

    public static void main(String args[]){
        int[] myArr = new int[]{2,3,4,1};
        int target = 7;
        TwoSum obj = new TwoSum();
        System.out.println(target+" sum found at indices "+obj.twoSum(myArr, target)[0]+" and "+obj.twoSum(myArr, target)[1]);

    }
}