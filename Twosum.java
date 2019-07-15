//Time complexity - O(n) 
// Space complexity - O(n)
// HashMap to store values and iterate by searching for the difference from the target

import java.util.*;

class Twosum {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            hmap.put(nums[i], i);
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            if(hmap.get(target - nums[i]) != null){
                result[0] = hmap.get(target-nums[i]);
                result[1] = i;
            }
        }
        
        return result;
    }
    public static void main(String[] args){
        System.out.println("Two Sum");
        Twosum obj = new Twosum();
        int[] nums = {2,8,11,15, 7};
        int target = 23;
        int[] result = obj.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}