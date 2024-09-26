/**
 * Time Complexity : O(n) where n is the number of elements in the array
 * Space Complexity: O(n) as the hashmap may contain at most n elements in the worst case
 * Executed on leetcode? Yes
 * Issues Coding? No
 * Approach: 1. We use a hashmap to store elements as keys and their indices as values.
 * 2. we store the current element and its index if map doesnt contain that key value pair. 
 * 3. if the map contains the target-current element and if the index of this complement element and the current is not the same, we return the indices of the current element and complement element
 * 4. if we dont the current element and compliement pair, we return {-1,-1}
 */

import java.util.*;
class two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;++i)
        {
            int current_element = nums[i];
            int search = target - current_element;
            if(!map.containsKey(current_element))
            {
                map.put(current_element,i);
            }
            if(map.containsKey(search) && map.get(search)!=i)
            {
                return new int[]{i,map.get(search)};
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("["+result[1]+","+result[0]+"]");
        
    }
}