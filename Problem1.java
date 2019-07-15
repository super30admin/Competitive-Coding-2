import java.util.*;


class Solution {
    public int[] twoSum(int[] nums, int target) {
     //create a hashmap to store the value and index of each array element
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int n = nums[i];
            if(map.containsKey(target-n)) //does the array contain an element which is equal to target-current element
                return new int[]{map.get(target-n),i}; //if yes, return that index and current index
            map.put(n,i); //put the element and it's index in the hashmap
        }
        throw new IllegalStateException("Target sum cannot be achieved with given array");
    }
}