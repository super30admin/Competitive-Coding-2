package leetcode;

//Space complexity = O(n)
//Time complexity = O(1)

import java.util.HashMap;

class Faang29{
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hash_map = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++)
        {

            int req=target-nums[i] ;
            if( hash_map.containsKey(req)){
                int[] intArray = new int[]{ hash_map.get(req),i};
                return intArray;
            }
            hash_map.put(nums[i], i);
        }
        return null;

    }

    public static void main(String[] args) {
        int[] nums = { 1,4,5,7};
        int target =10;
        Faang29 obj=new Faang29();
        int[] array = obj.twoSum(nums,target);
        for (int element : array) {
            System.out.println(element);
        }
    }

}